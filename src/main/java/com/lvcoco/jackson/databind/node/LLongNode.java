package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.LongNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 18:06
 */
public class LLongNode extends AbstractNode<LongNode, Long> {
    public LLongNode(LongNode node) {
        super(node);
    }

    @Override
    public Long getValue() {
        return getNode().longValue();
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.NUMBER;
    }

    @Override
    public NumberType getNumberType() {
        return NumberType.LONG;
    }
}
