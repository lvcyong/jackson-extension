package com.lvcoco.jackson.extension;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.ser.std.NumberSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import io.vavr.jackson.datatype.VavrModule;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static com.lvcoco.jackson.function.FunctionHelper.wrap;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 22:48
 */
public class JacksonHelper {
    private static final String DATE_TIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FORMATTER = "yyyy-MM-dd";
    private static final String TIME_FORMATTER = "HH:mm:ss";

    private static final JsonMapper JSON_MAPPER;

    static {
        JSON_MAPPER = new JsonMapper();
        JSON_MAPPER
                // .setTimeZone(TimeZone.getTimeZone("GMT+8"))
                .setDateFormat(new SimpleDateFormat(DATE_TIME_FORMATTER))
                .registerModule(new Jdk8Module())
                .registerModule(new VavrModule())
                .registerModule(getJavaTimeModule())
                .registerModule(getParameterNamesModule())
                .enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        ;

        // 忽略未知的JSON字段
        JSON_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 不允许基本类型为null
        JSON_MAPPER.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);

    }

    private static ParameterNamesModule getParameterNamesModule() {
        ParameterNamesModule module = new ParameterNamesModule();
        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(long.class, ToStringSerializer.instance);
        module.addSerializer(NumberSerializer.bigDecimalAsStringSerializer());
        return module;
    }

    private static JavaTimeModule getJavaTimeModule() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(TIME_FORMATTER);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMATTER);

        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(dateFormatter));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(timeFormatter));
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));

        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(dateFormatter));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(timeFormatter));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter));

        return javaTimeModule;
    }

    public static <T> T readValue(String json, Class<T> valueType) {
        return json == null ? null : wrap(() -> JSON_MAPPER.readValue(json, valueType));
    }

    public static <T> T readValue(String json, TypeReference<T> valueTypeRef) {
        return json == null ? null : wrap(() -> JSON_MAPPER.readValue(json, valueTypeRef));
    }

    public static String writeValueAsString(Object obj) {
        return obj == null ? null : wrap(() -> JSON_MAPPER.writeValueAsString(obj));
    }

    public static String writeValueAsPrettyString(Object obj) {
        return obj == null ? null : wrap(() -> JSON_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
    }

    public static <T> T convertValue(Object fromValue, TypeReference<T> toValueTypeRef) {
        return fromValue == null ? null : JSON_MAPPER.convertValue(fromValue, toValueTypeRef);
    }

    public static JsonNode readTree(String json) {
        return json == null ? NullNode.getInstance() : wrap(() -> JSON_MAPPER.readTree(json));
    }

    public static JsonNode valueToTree(Object fromValue) {
        return JSON_MAPPER.valueToTree(fromValue);
    }

    public static <T> T treeToValue(TreeNode treeNode, Class<T> valueType) {
        return treeNode == null ? null : wrap(() -> JSON_MAPPER.treeToValue(treeNode, valueType));
    }

    public static boolean isJson(String str) {
        try {
            JSON_MAPPER.readTree(str);
            return true;
        } catch (JsonProcessingException e) {
            return false;
        }
    }
}
