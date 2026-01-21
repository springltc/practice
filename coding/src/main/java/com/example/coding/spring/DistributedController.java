package com.example.coding.spring;

import com.alibaba.fastjson.JSON;
import com.example.coding.spring.aop.DistributedLock;
import com.example.coding.spring.aop.SystemEnum;
import com.example.coding.spring.model.DistributedReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liutc
 * @date 2026/1/9 14:17
 */
@RestController
public class DistributedController {

    @PostMapping("/distributed/test")
//    @DistributedLock(system = SystemEnum.COMMODITY, key = "#{#req.skuName+'_'+#req.spec+'_'+#req.type}", duration = 30L)
    @DistributedLock(system = SystemEnum.COMMODITY, key = "#req.skuName+'_'+#req.spec+'_'+#req.type", duration = 30L)
    public void test(@RequestBody DistributedReq req) {
        System.out.println(JSON.toJSONString(req));
    }

}
