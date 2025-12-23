package com.example.coding.json.serializer;

import com.example.coding.json.model.Status;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author liutc
 * @date 2025/12/22 18:39
 */
public class EnumSerializer extends JsonSerializer<Status> {

    @Override
    public void serialize(Status value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        if (value == null) {
            gen.writeNull();
            return;
        }

        gen.writeStartObject();
        gen.writeNumberField("code", value.getCode());
        gen.writeStringField("desc", value.getDesc());
        gen.writeEndObject();
    }

}
