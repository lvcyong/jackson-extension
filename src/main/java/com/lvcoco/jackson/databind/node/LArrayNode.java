package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.databind.node.ArrayNode;
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
public class LArrayNode extends AbstractNode<ArrayNode, Object[]> {
    public LArrayNode(ArrayNode node) {
        super(node);
    }

    @Override
    public Object[] getValue() {
        return null;
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.ARRAY;
    }
}
