package com.example.coding.json.config;

import com.example.coding.json.serializer.NullSafeSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;

/**
 * @author liutc
 * @date 2025/12/23 11:00
 */
//@Configuration
@SuppressWarnings("unchecked")
public class JacksonNullSerializerConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();

        // 全局注册 null 值处理序列化器
//        module.addSerializer(List.class, new NullToEmptyListSerializer.ForList());

        // 或者使用通用序列化器
        module.addSerializer(Object.class, new NullSafeSerializer());

        mapper.registerModule(module);

        // 配置全局的 null 处理策略
        // mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); // 不序列化 null
        // mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY); // 不序列化空值

        return mapper;
    }
}
