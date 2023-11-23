package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.math.BigInteger;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 18:06
 */
public class LBigIntegerNode extends AbstractNode<BigIntegerNode, BigInteger> {
    public LBigIntegerNode(BigIntegerNode node) {
        super(node);
    }

    @Override
    public BigInteger getValue() {
        return getNode().bigIntegerValue();
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.NUMBER;
    }

    @Override
    public NumberType getNumberType() {
        return NumberType.BIG_INTEGER;
    }
}
