package com.example.coding.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author liutc
 * @date 2023/12/21 13:29
 */
@Service
public class AsyncService {

    @Async
    public void async() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("12345");
    }
}
