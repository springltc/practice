package com.example.coding.spring.util;

import org.springframework.util.StopWatch;

/**
 * @author liutc
 * @date 2026/1/8 22:57
 */
public class StopWatchUtil {

    public static void main(String[] args) {
        StopWatch watch = new StopWatch("订单服务监控");
        watch.start("查询订单");
        // 业务逻辑...
        watch.stop();
        System.out.println(watch.prettyPrint());// 输出格式化报告
    }

}
