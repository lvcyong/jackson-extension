package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.*;

import java.util.Arrays;
import java.util.Objects;

/**
 * <pre>
 *
 * </pre>
 * @author lvcoco
 * @date 2023/11/22 17:22
 * @version 1.0
 *
 */
public enum LJsonNodeType {
    ARRAY(JsonNodeType.ARRAY) {
        @Override
        public LArrayNode getNode(JsonNode node) {
            return new LArrayNode((ArrayNode) node);
        }
    },

    BINARY(JsonNodeType.BINARY) {
        @Override
        public LBinaryNode getNode(JsonNode node) {
            return new LBinaryNode((BinaryNode) node);
        }
    },

    BOOLEAN(JsonNodeType.BOOLEAN) {
        @Override
        public LBooleanNode getNode(JsonNode node) {
            return new LBooleanNode((BooleanNode) node);
        }
    },

    MISSING(JsonNodeType.MISSING) {
        @Override
        public LMissingNode getNode(JsonNode node) {
            return new LMissingNode((MissingNode) node);
        }
    },

    NULL(JsonNodeType.NULL) {
        @Override
        public LNullNode getNode(JsonNode node) {
            return new LNullNode((NullNode) node);
        }
    },

    OBJECT(JsonNodeType.OBJECT) {
        @Override
        public LObjectNode getNode(JsonNode node) {
            return new LObjectNode((ObjectNode) node);
        }
    },

    POJO(JsonNodeType.POJO) {
        public LPOJONode getNode(JsonNode node) {
            return new LPOJONode((POJONode) node);
        }
    },

    STRING(JsonNodeType.STRING) {
        public LTextNode getNode(JsonNode node) {
            return new LTextNode((TextNode) node);
        }
    },

    NUMBER(JsonNodeType.NUMBER) {
        @Override
        public AbstractNode<?, ?> getNode(JsonNode node) {
            switch (node.numberType()) {
                case INT -> {
                    return new LIntNode((IntNode) node);
                }
                case LONG -> {
                    return new LLongNode((LongNode) node);
                }
                case FLOAT -> {
                    return new LFloatNode((FloatNode) node);
                }
                case DOUBLE -> {
                    return new LDoubleNode((DoubleNode) node);
                }
                case BIG_INTEGER -> {
                    return new LBigIntegerNode((BigIntegerNode) node);
                }
                case BIG_DECIMAL -> {
                    return new LDecimalNode((DecimalNode) node);
                }
                default -> throw new UnsupportedOperationException(node.getNodeType().name());
            }

        }
    }

    ;

    public abstract AbstractNode<?, ?> getNode(JsonNode node);

    public Object getNodeValue(JsonNode node) {
        return getNode(node).getValue();
    }

    public static AbstractNode<?, ?> getLNode(JsonNode node) {
        return getNodeType(node).getNode(node);
    }

    public static Object getValue(JsonNode node) {
        Objects.requireNonNull(node, "node must not be null");

        return getNodeType(node).getNodeValue(node);
    }

    public static LJsonNodeType getNodeType(JsonNode node) {
        Objects.requireNonNull(node, "node must not be null");

        return Arrays.stream(LJsonNodeType.values())
                .filter(it -> it.getJsonNodeType() == node.getNodeType())
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException(node.getNodeType().name()));
    }

    private final JsonNodeType jsonNodeType;

    LJsonNodeType(JsonNodeType jsonNodeType) {
        this.jsonNodeType = jsonNodeType;
    }

    public JsonNodeType getJsonNodeType() {
        return jsonNodeType;
    }
}
