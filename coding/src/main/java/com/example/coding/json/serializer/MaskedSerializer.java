package com.example.coding.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author liutc
 * @date 2025/12/22 18:35
 */
public class MaskedSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        if (value == null || value.isEmpty()) {
            gen.writeString(value);
            return;
        }

        // 简单策略：全部替换为 ****
        gen.writeString("****");
    }

    private String mask(String value) {
        if (value.length() <= 2) {
            return "**";
        }
        return value.charAt(0) + "****" + value.charAt(value.length() - 1);
    }
}
