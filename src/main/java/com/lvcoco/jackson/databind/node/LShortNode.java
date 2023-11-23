package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ShortNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 18:06
 */
public class LShortNode extends AbstractNode<ShortNode, Short> {
    public LShortNode(ShortNode node) {
        super(node);
    }

    @Override
    public Short getValue() {
        return getNode().shortValue();
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
