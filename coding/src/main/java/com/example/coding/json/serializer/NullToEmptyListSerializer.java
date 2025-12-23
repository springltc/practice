package com.example.coding.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liutc
 * @date 2025/12/23 10:43
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class NullToEmptyListSerializer extends JsonSerializer<Object> {
    // 是否在序列化时检查集合是否真的为空
    private boolean checkEmpty = true;

    // 空集合的默认值（可以预定义一些默认元素）
    private List<?> defaultElements = null;

    public NullToEmptyListSerializer() {
    }

    public NullToEmptyListSerializer(boolean checkEmpty) {
        this.checkEmpty = checkEmpty;
    }

    public NullToEmptyListSerializer(List<?> defaultElements) {
        this.defaultElements = defaultElements;
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (value == null) {
            writeEmptyArray(gen);
        } else if (checkEmpty && isEmptyCollection(value)) {
            writeEmptyArray(gen);
        } else {
            // 正常序列化
            gen.writeObject(value);
        }
    }

    /**
     * 检查集合是否为空
     */
    private boolean isEmptyCollection(Object value) {
        if (value instanceof Collection) {
            return ((Collection<?>) value).isEmpty();
        } else if (value instanceof Object[]) {
            return ((Object[]) value).length == 0;
        } else if (value instanceof Map) {
            return ((Map<?, ?>) value).isEmpty();
        }
        return false;
    }

    /**
     * 写入空数组
     */
    private void writeEmptyArray(JsonGenerator gen) throws IOException {
        gen.writeStartArray();

        // 如果有默认元素，写入它们
        if (defaultElements != null && !defaultElements.isEmpty()) {
            for (Object element : defaultElements) {
                gen.writeObject(element);
            }
        }

        gen.writeEndArray();
    }

    /**
     * 专门处理 List 类型
     */
    public static class ForList extends JsonSerializer<List<?>> {
        @Override
        public void serialize(List<?> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            if (value == null || value.isEmpty()) {
                gen.writeStartArray();
                gen.writeEndArray();
            } else {
                gen.writeObject(value);
            }
        }
    }

    /**
     * 专门处理 Set 类型
     */
    public static class ForSet extends JsonSerializer<Set<?>> {
        @Override
        public void serialize(Set<?> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            if (value == null || value.isEmpty()) {
                gen.writeStartArray();
                gen.writeEndArray();
            } else {
                gen.writeObject(value);
            }
        }
    }

    /**
     * 专门处理 Collection 类型
     */
    public static class ForCollection extends JsonSerializer<Collection<?>> {
        @Override
        public void serialize(Collection<?> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            if (value == null || value.isEmpty()) {
                gen.writeStartArray();
                gen.writeEndArray();
            } else {
                gen.writeObject(value);
            }
        }
    }

    /**
     * 专门处理数组类型
     */
    public static class ForArray extends JsonSerializer<Object[]> {
        @Override
        public void serialize(Object[] value, JsonGenerator gen,
                              SerializerProvider provider) throws IOException {
            if (value == null || value.length == 0) {
                gen.writeStartArray();
                gen.writeEndArray();
            } else {
                gen.writeObject(value);
            }
        }
    }

}
