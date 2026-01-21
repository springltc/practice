package com.example.coding.feign.config;

import com.example.coding.feign.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class WechatFeignConfig {

    @Bean
    public Decoder wechatDecoder() {
        return (response, type) -> {
            String body = getResponseBody(response);

            validateWechatResponse(body);

            return JSONUtil.toObject(body, JSONUtil.OBJECT_MAPPER.constructType(type));
        };
    }

    @Bean
    public ErrorDecoder wechatErrorDecoder() {
        return (methodKey, response) -> {
            String body = getResponseBody(response);

            validateWechatResponse(body);

            throw new RuntimeException("失败");
        };
    }

    /**
     * 读取响应体
     */
    private static String getResponseBody(Response response) {
        try {
            if (response.body() == null) {
                throw new RuntimeException("失败");
            }
            return IOUtils.toString(response.body().asInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error("读取微信响应体异常", e);
            throw new RuntimeException("失败");
        }
    }

    /**
     * 校验微信返回体是否包含错误码
     */
    private static void validateWechatResponse(String body) {
        if (StringUtils.isBlank(body)) {
            throw new RuntimeException("失败");
        }

        log.info("validateWechatResponse body: {}", body);

        JsonNode json;
        try {
            json = JSONUtil.OBJECT_MAPPER.readTree(body);
        } catch (JsonProcessingException e) {
            log.warn("微信返回非JSON内容: {}", body);
            throw new RuntimeException("失败");
        }

        log.info("validateWechatResponse json: {}", JSONUtil.toJSONString(json));

        // 有些接口没有 errcode 字段 -> 视为成功
        if (!json.has("errcode")) {
            return;
        }

        int errcode = json.get("errcode").asInt(0);
        if (errcode == 0) {
            return;
        }

        String errmsg = json.has("errmsg") ? json.get("errmsg").asText() : "unknown error";
        log.warn("微信接口返回错误: {} - {}", errcode, errmsg);
        throw new RuntimeException("失败");
    }
}
