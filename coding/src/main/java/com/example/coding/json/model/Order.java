package com.example.coding.json.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

/**
 * @author liutc
 * @date 2025/12/23 11:01
 */
public class Order {
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL) // 仅当非空时序列化
    private String remark;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY) // 非空集合才序列化
    private List<Object> items;

}
