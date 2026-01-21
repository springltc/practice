package com.example.coding.feign;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Slf4j
public class JSONUtil {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
            .configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);

    public static <T> T toObject(String content, JavaType valueType) {
        try {
            return OBJECT_MAPPER.readValue(content, valueType);
        } catch (Exception e) {
            log.warn("反序列化对象失败:{}-{}", valueType.getTypeName(), content, e);
            throw new RuntimeException("第三方服务调用异常");
        }
    }

    public static <T> T toObject(String content, Class<T> valueType) {
        try {
            return OBJECT_MAPPER.readValue(content, valueType);
        } catch (Exception e) {
            log.warn("反序列化对象失败:{}-{}", valueType.getTypeName(), content, e);
            throw new RuntimeException("第三方服务调用异常");
        }
    }

    public static <T> T toObject(String content, TypeReference<T> typeReference) {
        try {
            return OBJECT_MAPPER.readValue(content, typeReference);
        } catch (Exception e) {
            log.warn("反序列化对象失败:{}-{}", typeReference.getType().getTypeName(), content, e);
            throw new RuntimeException("第三方服务调用异常");
        }
    }

    public static String toJSONString(Object params) {
        try {
            return OBJECT_MAPPER.writeValueAsString(params);
        } catch (Exception exception) {
            log.warn("序列化对象失败:{}", params, exception);
            throw new RuntimeException("第三方服务调用异常");
        }
    }

    public static String normalize(String content, Class valueType) {
        Object object = toObject(content, valueType);
        return Objects.isNull(object) ? null : toJSONString(object);
    }

    public static <T> T fromJsonOrCast(Object value, Class<T> targetClass) {
        if (value == null) {
            return null;
        }

        return (value instanceof String) ? toObject((String) value, targetClass) : (T) value;
    }

    public static Map<String, Object> toMap(String content) {
        try {
            return OBJECT_MAPPER.readValue(content, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception exception) {
            log.warn("序列化对象成Map失败:{}", content, exception);
            throw new RuntimeException("第三方服务调用异常");
        }
    }

    public static Map<String, Object> toMap(Object object) {

        try {
            return toMap(OBJECT_MAPPER.writeValueAsString(object));
        } catch (Exception exception) {
            log.warn("将对象转成Map失败:{}", object, exception);
            throw new RuntimeException("第三方服务调用异常");
        }
    }

    public static class TypeRef {

        private TypeRef() {
        }

        // 常用基础类型
        public static TypeReference<Set<String>> setOfString() {
            return new TypeReference<Set<String>>() {
            };
        }

        public static TypeReference<List<String>> listOfString() {
            return new TypeReference<List<String>>() {
            };
        }

        public static TypeReference<Map<String, String>> mapOfString() {
            return new TypeReference<Map<String, String>>() {
            };
        }

        // 泛型通用类型
        public static <T> TypeReference<Set<T>> setOf(Class<T> clazz) {
            return new TypeReference<Set<T>>() {
            };
        }

        public static <T> TypeReference<List<T>> listOf(Class<T> clazz) {
            return new TypeReference<List<T>>() {
            };
        }

        public static <K, V> TypeReference<Map<K, V>> mapOf(Class<K> keyClass, Class<V> valueClass) {
            return new TypeReference<Map<K, V>>() {
            };
        }
    }
}
