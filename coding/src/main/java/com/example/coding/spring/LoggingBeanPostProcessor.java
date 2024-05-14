package com.example.coding.spring;

/**
 * @author liutc
 * @date 2024/4/18 10:14
 */

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LoggingBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        // 在 Bean 初始化之前执行的操作
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
//        System.out.println("====postProcessAfterInitialization====");
        return bean;
    }
}

