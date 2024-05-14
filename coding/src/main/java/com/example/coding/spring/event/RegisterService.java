package com.example.coding.spring.event;

import com.example.coding.spring.aop.AppConfig;
import com.example.coding.spring.aop.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author liutc
 * @date 2024/4/19 13:30
 */
@Service
public class RegisterService {

    @Autowired
    protected ApplicationContext applicationContext;

    public Object register(RegisterInfo registerInfo) {

        //用户注册核心代码

        //发送一个注册完成的事件
        applicationContext.publishEvent(new RegisterSuccessEvent(registerInfo));

        return null;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        RegisterService registerService = context.getBean(RegisterService.class);
        RegisterInfo registerInfo = new RegisterInfo();
        registerInfo.setMessage("hello world");
        registerService.register(registerInfo);
        context.close();
    }

}
