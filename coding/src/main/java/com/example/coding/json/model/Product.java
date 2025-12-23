package com.example.coding.json.model;

import com.example.coding.json.serializer.NullToEmptyListSerializer;
import com.example.coding.json.serializer.NullToEmptyObjectSerializer;
import com.example.coding.json.serializer.NullToEmptyStringSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author liutc
 * @date 2025/12/23 10:22
 */
@Data
public class Product {
    // null 值被序列化为空对象 {}
    @JsonSerialize(nullsUsing = NullToEmptyObjectSerializer.class)
    private Map<String, Object> metadata;

    // null 集合被序列化为空数组 []
    @JsonSerialize(nullsUsing = NullToEmptyListSerializer.class)
    private List<String> tags;

    // null 字符串被序列为空字符串 ""
    @JsonSerialize(nullsUsing = NullToEmptyStringSerializer.class)
    private String description;

    public Product(Map<String, Object> metadata, List<String> tags, String description) {
        this.metadata = metadata;
        this.tags = tags;
        this.description = description;
    }
}
