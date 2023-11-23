package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.node.DoubleNode;
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
public class LDoubleNode extends AbstractNode<DoubleNode, Double> {
    public LDoubleNode(DoubleNode node) {
        super(node);
    }

    @Override
    public Double getValue() {
        return getNode().doubleValue();
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.NUMBER;
    }

    @Override
    public NumberType getNumberType() {
        return NumberType.DOUBLE;
    }
}
