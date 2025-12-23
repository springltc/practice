package com.example.coding.json.model;

import com.alibaba.fastjson.JSON;
import com.example.coding.json.serializer.IgnoreZeroSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * @author liutc
 * @date 2025/12/23 11:40
 */
@Data
public class OrderVO {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int count;   // 默认 0

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private boolean paid; // 默认 false

    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = IgnoreZero.class)
//    @JsonSerialize(using = IgnoreZeroSerializer.class)
    private Integer number;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        OrderVO orderVO = new OrderVO();
        System.out.println(objectMapper.writeValueAsString(orderVO));

        OrderVO orderVO2 = new OrderVO();
        orderVO2.setCount(2);
        orderVO2.setPaid(true);
        orderVO2.setNumber(0);
        System.out.println(objectMapper.writeValueAsString(orderVO2));
    }

    public static class IgnoreZero {
        @Override
        public boolean equals(Object obj) {
            return obj instanceof Integer && ((Integer) obj) == 0;
        }
    }
}
