package com.example.coding.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liutc
 * @date 2024/4/16 13:44
 */
@Service
public class ServiceB{

    @Autowired
    private ServiceA serviceA;

}
