package com.lvcoco.jackson.extension;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public void test() throws Exception {
        DemoModel demoModel = new DemoModel();
        String json = JacksonHelper.writeValueAsPrettyString(demoModel);
        System.err.println(json);
    }

}