package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.databind.node.BooleanNode;
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
public class LBooleanNode extends AbstractNode<BooleanNode, Boolean> {
    public LBooleanNode(BooleanNode node) {
        super(node);
    }

    @Override
    public Boolean getValue() {
        return getNode().booleanValue();
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.BOOLEAN;
    }
}
