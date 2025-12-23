package com.example.coding.json;

import com.example.coding.json.model.Status;
import com.example.coding.json.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

/**
 * @author liutc
 * @date 2025/12/22 18:26
 */
public class UserTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        User user = new User(1L, "张三", new Date(), "123456", Status.ENABLED);
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);
    }
}
