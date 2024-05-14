package com.example.coding.spring;

import org.springframework.stereotype.Component;

// 实现 Loggable 接口的具体 Bean
@Component
public class MyLoggableBean implements Loggable {

    @Override
    public void enableLogging() {
        System.out.println("Logging has been enabled for " + this.getClass().getSimpleName());
    }

    // 其他 Bean 的业务逻辑方法
}
