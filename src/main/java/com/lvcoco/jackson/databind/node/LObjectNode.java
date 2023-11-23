package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 18:06
 */
public class LObjectNode extends AbstractNode<ObjectNode, Object> {
    public LObjectNode(ObjectNode node) {
        super(node);
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.OBJECT;
    }
}
