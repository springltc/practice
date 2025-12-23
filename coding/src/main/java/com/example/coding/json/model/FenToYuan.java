package com.example.coding.json.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author liutc
 * @date 2025/12/23 11:09
 */
@Data
public class FenToYuan {

    private String orderNo;

    @JsonSerialize(using = FenToYuanSerializer.class)
    private Long totalAmount; // 数据库存的是分

    // 自定义序列化器
    public static class FenToYuanSerializer extends JsonSerializer<Long> {
        @Override
        public void serialize(Long value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            if (value == null) {
                gen.writeNull();
            } else {
                // 将分转换为元（保留2位小数）
                BigDecimal yuan = new BigDecimal(value).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
                gen.writeString(yuan.toString() + "元");
            }
        }
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        // 使用
        FenToYuan order = new FenToYuan("ORD123", 1999L); // 1999分
        String json = objectMapper.writeValueAsString(order);
        System.out.println(json);
    }

    public FenToYuan(String orderNo, Long totalAmount) {
        this.orderNo = orderNo;
        this.totalAmount = totalAmount;
    }
}
