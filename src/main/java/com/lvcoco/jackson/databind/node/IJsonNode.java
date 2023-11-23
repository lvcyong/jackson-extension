package com.lvcoco.jackson.databind.node;

import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.io.Serializable;

/**
 * <pre>
 *
 * </pre>
 *
 * @author lvcoco
 * @version 1.0
 * @date 2023/11/22 18:11
 */
public interface IJsonNode<N extends JsonNode, R> extends Serializable {

    N getNode();

    JsonNodeType getNodeType();

    NumberType getNumberType();

    R getValue();

}
