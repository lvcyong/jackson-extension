package com.lvcoco.jackson.extension;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.jsonzou.jmockdata.JMockData;
import com.lvcoco.jackson.databind.node.LJsonNodeType;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 23:24
 */
class JacksonHelperTest {

    private static final Logger LOG = LoggerFactory.getLogger(JacksonHelperTest.class);

    @Test
    public void test1() throws Exception {
        DemoModel demoModel = new DemoModel();
        String json = JacksonHelper.writeValueAsPrettyString(demoModel);
        System.err.println(json);
    }

    @Test
    public void test2() throws Exception {
        DemoModel demoModel = JMockData.mock(DemoModel.class);
        String json = JacksonHelper.writeValueAsPrettyString(demoModel);
        System.err.println(json);
    }

    @Test
    public void test3() throws Exception {
        BigDecimal b = new BigDecimal(Double.MAX_VALUE);
        System.err.println(b.toPlainString());
        System.err.println(b.toString());

        Long l = Long.MAX_VALUE;
        System.err.println(l);
        System.err.println(l.toString());
    }

    @Test
    public void test4() throws Exception {
        String s = """
                {
                    "a": 1,
                    "b": 2
                }
                """;
        System.err.println(JacksonHelper.isJson(s));
    }

    @Test
    public void test5() throws Exception {
        DemoModel demoModel = new DemoModel();
        JsonNode jsonNode = JacksonHelper.valueToTree(demoModel.getBigIntegerArray1());
        Object value = LJsonNodeType.getValue(jsonNode);
        System.err.println(value);
    }

}