package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.TextNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 18:06
 */
public class LTextNode extends AbstractNode<TextNode, String> {
    public LTextNode(TextNode node) {
        super(node);
    }

    @Override
    public String getValue() {
        return getNode().textValue();
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.STRING;
    }
}
