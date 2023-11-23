package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.node.DecimalNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.math.BigDecimal;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 18:06
 */
public class LDecimalNode extends AbstractNode<DecimalNode, BigDecimal> {
    public LDecimalNode(DecimalNode node) {
        super(node);
    }

    @Override
    public BigDecimal getValue() {
        return getNode().decimalValue();
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.NUMBER;
    }

    @Override
    public NumberType getNumberType() {
        return NumberType.BIG_DECIMAL;
    }
}
