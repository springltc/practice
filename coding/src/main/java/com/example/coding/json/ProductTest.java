package com.example.coding.json;

import com.example.coding.json.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author liutc
 * @date 2025/12/23 10:24
 */
public class ProductTest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        // 使用示例
        Product product = new Product(null, null, null);
        String json = objectMapper.writeValueAsString(product);
        System.out.println(json);
    }

}
