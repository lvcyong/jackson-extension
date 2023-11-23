package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 18:06
 */
public class LNullNode extends AbstractNode<NullNode, Object> {
    public LNullNode(NullNode node) {
        super(node);
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.NULL;
    }
}
