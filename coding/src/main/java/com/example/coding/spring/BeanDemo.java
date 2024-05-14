package com.example.coding.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liutc
 * @date 2024/4/16 09:55
 */
public class BeanDemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        // 通过名称获取bean实例
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
    }
}
