package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.POJONode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 18:06
 */
public class LPOJONode extends AbstractNode<POJONode, Object> {
    public LPOJONode(POJONode node) {
        super(node);
    }

    @Override
    public Object getValue() {
        return getNode().getPojo();
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.POJO;
    }
}
