package com.example.coding;

import com.example.coding.service.AsyncService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CodingApplicationTests {

    @Resource
    private AsyncService asyncService;

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        try {
            asyncService.async();
            System.out.println("执行:asyncService.async()");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
