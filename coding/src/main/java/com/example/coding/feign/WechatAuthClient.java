package com.example.coding.feign;


import com.example.coding.feign.config.WechatFeignConfig;
import com.example.coding.feign.model.StableAccessToken;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "WechatAuthClient", url = "https://api.weixin.qq.com", configuration = WechatFeignConfig.class)
public interface WechatAuthClient {

    @PostMapping("/cgi-bin/stable_token")
    StableAccessToken.Response getStableAccessToken(@RequestBody StableAccessToken.Request request);

    @PostMapping("/cgi-bin/message/custom/send")
    String sendCustomMessage(@RequestParam("access_token") String accessToken, @RequestBody String body);

}
