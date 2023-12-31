package com.lvcoco.jackson.extension;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
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
                .registerModule(new JavaTimeModule())
                .registerModule(new ParameterNamesModule())
                .registerModule(new VavrModule())
                .registerModule(getSimpleModule())
                .enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)
                .enable(SerializationFeature.WRITE_SELF_REFERENCES_AS_NULL)
                // 禁用时间戳格式
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        ;

        // 配置对空值的处理
        JSON_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // 配置是否缩进输出
        JSON_MAPPER.configure(SerializationFeature.INDENT_OUTPUT, true);

        // 忽略未知的JSON字段
        JSON_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 不允许基本类型为null
        JSON_MAPPER.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);

    }

    private static SimpleModule getSimpleModule() {
        SimpleModule module = new SimpleModule();

        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(long.class, ToStringSerializer.instance);

        module.addSerializer(NumberSerializer.bigDecimalAsStringSerializer());

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(TIME_FORMATTER);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMATTER);

        module.addSerializer(LocalDate.class, new LocalDateSerializer(dateFormatter));
        module.addSerializer(LocalTime.class, new LocalTimeSerializer(timeFormatter));
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));

        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(dateFormatter));
        module.addDeserializer(LocalTime.class, new LocalTimeDeserializer(timeFormatter));
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter));

        return module;
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

    public static <T> T treeToValue(TreeNode treeNode, TypeReference<T> toValueTypeRef) {
        return treeNode == null ? null : wrap(() -> JSON_MAPPER.treeToValue(treeNode, toValueTypeRef));
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
