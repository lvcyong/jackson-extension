package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.util.Objects;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 18:17
 */
public abstract class AbstractNode<N extends JsonNode, R> implements IJsonNode<N, R> {
    private final N node;

    public AbstractNode(N node) {
        Objects.requireNonNull(node, "node must not be null");

        this.node = node;
    }

    @Override
    public JsonNodeType getNodeType() {
        return node.getNodeType();
    }

    @Override
    public NumberType getNumberType() {
        throw new UnsupportedOperationException(getNodeType().name());
    }

    @Override
    public N getNode() {
        return node;
    }

}
