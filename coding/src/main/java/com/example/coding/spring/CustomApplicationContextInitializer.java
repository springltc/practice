package com.example.coding.spring;

/**
 * @author liutc
 * @date 2024/4/18 14:19
 */
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class CustomApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // 在这里添加自定义的初始化逻辑
        // 例如设置属性、注册Bean定义等
        System.out.println("================");
    }
}
