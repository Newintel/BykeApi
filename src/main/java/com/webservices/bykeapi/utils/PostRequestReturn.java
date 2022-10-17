package com.webservices.bykeapi.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonObject;

import javax.persistence.Entity;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRequestReturn<T> {
    private Map<String, Method> propertiesMap;
    private final T entity;

    public PostRequestReturn(T entity, String[] properties) {
        this.entity = entity;
        try {
            propertiesMap = new HashMap<>();
            for (String property : properties) {
                propertiesMap.put(property,
                        entity.getClass().getMethod("get" + property.substring(0, 1).toUpperCase()
                        + property.substring(1))
                );
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public ObjectNode getJson() {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode node = mapper.createObjectNode();

        for (Map.Entry<String, Method> entry : propertiesMap.entrySet()) {
            try {
                node.put(entry.getKey(), entry.getValue().invoke(entity).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return node;
    }
}
