package com.example.coding.spring;

/**
 * @author liutc
 * @date 2024/4/19 10:12
 */

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class MyDisposableBean implements DisposableBean {

    // 初始化方法
    public void init() {
//        System.out.println("Bean initialization code here");
    }

    // 销毁方法
    @Override
    public void destroy() throws Exception {
        System.out.println("Bean destruction code here");
    }
}

