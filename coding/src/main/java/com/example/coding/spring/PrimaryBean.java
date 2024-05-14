package com.example.coding.spring;

import org.springframework.stereotype.Component;

/**
 * @author liutc
 * @date 2024/4/18 09:27
 */
@Component
public class PrimaryBean {
    public PrimaryBean() {
        System.out.println("init primary bean");
    }

    @Override
    public String toString() {
        return "PrimaryBean{aaa}";
    }
}
