package com.example.coding.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liutc
 * @date 2025/12/23 10:54
 */
public class NullSafeSerializer extends JsonSerializer<Object> {

    public enum NullSafeStrategy {
        EMPTY_OBJECT,      // {} for Map/Object
        EMPTY_ARRAY,       // [] for Collection/Array
        EMPTY_STRING,      // "" for String
        NULL_VALUE,        // null (保持原样)
        CUSTOM_DEFAULT     // 自定义默认值
    }

    private NullSafeStrategy strategy;
    private Object defaultValue;

    // 类型特定的策略映射
    private Map<Class<?>, NullSafeStrategy> typeStrategyMap = new HashMap<>();

    public NullSafeSerializer() {
        this.strategy = NullSafeStrategy.NULL_VALUE; // 默认保持 null
        initDefaultTypeStrategies();
    }

    public NullSafeSerializer(NullSafeStrategy strategy) {
        this.strategy = strategy;
        initDefaultTypeStrategies();
    }

    public NullSafeSerializer(NullSafeStrategy strategy, Object defaultValue) {
        this.strategy = strategy;
        this.defaultValue = defaultValue;
        initDefaultTypeStrategies();
    }

    private void initDefaultTypeStrategies() {
        // 注册默认的类型策略
        typeStrategyMap.put(Map.class, NullSafeStrategy.EMPTY_OBJECT);
        typeStrategyMap.put(Collection.class, NullSafeStrategy.EMPTY_ARRAY);
        typeStrategyMap.put(List.class, NullSafeStrategy.EMPTY_ARRAY);
        typeStrategyMap.put(Set.class, NullSafeStrategy.EMPTY_ARRAY);
        typeStrategyMap.put(String.class, NullSafeStrategy.EMPTY_STRING);
        typeStrategyMap.put(Object[].class, NullSafeStrategy.EMPTY_ARRAY);
    }

    @Override
    public void serialize(Object value, JsonGenerator gen,
                          SerializerProvider provider) throws IOException {
        if (value != null) {
            gen.writeObject(value);
            return;
        }

        // 获取字段的实际类型
        Class<?> fieldType = getFieldType(gen, provider);

        // 确定使用哪个策略
        NullSafeStrategy useStrategy = determineStrategy(fieldType);

        // 应用策略
        applyStrategy(useStrategy, fieldType, gen);
    }

    /**
     * 获取字段的实际类型
     */
    private Class<?> getFieldType(JsonGenerator gen, SerializerProvider provider) {
        // 这里简化处理，实际应该从 SerializerProvider 获取
        // 在实际使用中，可能需要更复杂的类型推断
        return Object.class;
    }

    /**
     * 确定使用哪个策略
     */
    private NullSafeStrategy determineStrategy(Class<?> fieldType) {
        // 1. 首先检查类型特定的策略
        for (Map.Entry<Class<?>, NullSafeStrategy> entry : typeStrategyMap.entrySet()) {
            if (entry.getKey().isAssignableFrom(fieldType)) {
                return entry.getValue();
            }
        }

        // 2. 使用全局策略
        return strategy;
    }

    /**
     * 应用策略
     */
    private void applyStrategy(NullSafeStrategy strategy, Class<?> fieldType,
                               JsonGenerator gen) throws IOException {
        switch (strategy) {
            case EMPTY_OBJECT:
                gen.writeStartObject();
                gen.writeEndObject();
                break;

            case EMPTY_ARRAY:
                gen.writeStartArray();
                gen.writeEndArray();
                break;

            case EMPTY_STRING:
                gen.writeString("");
                break;

            case NULL_VALUE:
                gen.writeNull();
                break;

            case CUSTOM_DEFAULT:
                if (defaultValue != null) {
                    gen.writeObject(defaultValue);
                } else {
                    // 回退到基于类型的默认策略
                    if (Map.class.isAssignableFrom(fieldType)) {
                        gen.writeStartObject();
                        gen.writeEndObject();
                    } else if (Collection.class.isAssignableFrom(fieldType) ||
                            fieldType.isArray()) {
                        gen.writeStartArray();
                        gen.writeEndArray();
                    } else if (String.class.isAssignableFrom(fieldType)) {
                        gen.writeString("");
                    } else {
                        gen.writeNull();
                    }
                }
                break;

            default:
                gen.writeNull();
        }
    }
}
