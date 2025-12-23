package com.example.coding.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * @author liutc
 * @date 2025/12/23 10:28
 */
public class NullToEmptyObjectSerializer extends JsonSerializer<Object> {
    // 可以配置空对象的默认值
    private Map<String, Object> defaultValue;

    public NullToEmptyObjectSerializer() {
        this.defaultValue = Collections.emptyMap();
    }

    public NullToEmptyObjectSerializer(Map<String, Object> defaultValue) {
        this.defaultValue = defaultValue != null ? defaultValue : Collections.emptyMap();
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        if (value == null) {
            // 写入空对象
            gen.writeStartObject();

            // 如果配置了默认值，写入默认内容
            if (!defaultValue.isEmpty()) {
                for (Map.Entry<String, Object> entry : defaultValue.entrySet()) {
                    gen.writeObjectField(entry.getKey(), entry.getValue());
                }
            }

            gen.writeEndObject();
        } else {
            // 如果不是 null，正常序列化
            gen.writeObject(value);
        }
    }

}
