package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 18:06
 */
public class LMissingNode extends AbstractNode<MissingNode, Void> {
    public LMissingNode(MissingNode node) {
        super(node);
    }

    @Override
    public Void getValue() {
        return null;
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.MISSING;
    }
}
