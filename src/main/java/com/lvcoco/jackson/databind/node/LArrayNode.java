package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.util.ArrayList;
import java.util.List;

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
        ArrayNode arrayNode = getNode();
        List<Object> list = new ArrayList<>(arrayNode.size());
        for (JsonNode jsonNode : arrayNode) {
            list.add(LJsonNodeType.getValue(jsonNode));
        }
        return list.toArray();
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.ARRAY;
    }
}
