package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.databind.node.BinaryNode;
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
public class LBinaryNode extends AbstractNode<BinaryNode, byte[]> {
    public LBinaryNode(BinaryNode node) {
        super(node);
    }

    @Override
    public byte[] getValue() {
        return getNode().binaryValue();
    }

    @Override
    public JsonNodeType getNodeType() {
        return JsonNodeType.BINARY;
    }
}
