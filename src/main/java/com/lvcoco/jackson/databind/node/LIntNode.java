package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 18:06
 */
public class LIntNode extends AbstractNode<IntNode, Integer> {
    public LIntNode(IntNode node) {
        super(node);
    }

    @Override
    public Integer getValue() {
        return getNode().intValue();
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.NUMBER;
    }

    @Override
    public NumberType getNumberType() {
        return NumberType.INT;
    }
}
