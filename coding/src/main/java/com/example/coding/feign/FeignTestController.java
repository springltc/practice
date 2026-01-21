package com.example.coding.feign;

import com.alibaba.fastjson.JSON;
import com.example.coding.feign.model.StableAccessToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liutc
 * @date 2026/1/20 23:44
 */
@RestController
@Slf4j
public class FeignTestController {

    @Resource
    private WechatAuthClient wechatAuthClient;

    @GetMapping("/feign/test")
    public void test() {
        StableAccessToken.Request request = new StableAccessToken.Request();
        request.setAppId("wx776ddb27b3a80f93");
        request.setSecret("fe0714a193c8");
        wechatAuthClient.getStableAccessToken(request);
    }

    @PostMapping("/feign/test2")
    public void evaluateTest(@RequestBody String request) {
        String token = "100_eMhMZeUEeqUPolsfncdTN5VdjTqqTU69Etn-s_HR0aAJgEG_jKn6bs1O5uEO68b0C4EIHBh_9q29l3J7NZOWHbTjiIeVUcfEPwdTeHnp2YBKiJ60QQTne5kLdHnOGEcfQq84S2pHA2n35I-BVLWgAHDIYJ";
        wechatAuthClient.sendCustomMessage(token, request);
    }

}
