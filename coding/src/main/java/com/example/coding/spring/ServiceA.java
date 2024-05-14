package com.example.coding.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liutc
 * @date 2024/4/16 13:44
 */
@Service
public class ServiceA {


    /**
     * ┌─────┐
     * |  serviceA defined in file [/Users/Desktop/project/practice/coding/build/classes/java/main/com/example/coding/spring/ServiceA.class]
     * ↑     ↓
     * |  serviceB (field private com.example.coding.spring.ServiceA com.example.coding.spring.ServiceB.serviceA)
     * └─────┘
     *
     * @param serviceB
     */
    //  构造方法注入,会报循环依赖
//    public ServiceA(ServiceB serviceB) {
//
//    }

//      set方法注入,不会报循环依赖
    @Autowired
    private ServiceB serviceB;

}
