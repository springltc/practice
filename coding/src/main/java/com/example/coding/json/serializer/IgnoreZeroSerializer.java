package com.example.coding.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author liutc
 * @date 2025/12/23 11:55
 */
public class IgnoreZeroSerializer extends JsonSerializer<Integer> {
    @Override
    public void serialize(Integer value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != 0) {
            gen.writeNumber(value);
        }
        // value == 0 → 什么都不写
    }
}