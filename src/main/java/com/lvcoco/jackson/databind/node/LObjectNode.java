package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lvcoco.jackson.extension.JacksonHelper;

import java.util.Map;

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
        ObjectNode objectNode = getNode();
        return JacksonHelper.treeToValue(objectNode, new TypeReference<Map<String, Object>>() {});
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.OBJECT;
    }
}
