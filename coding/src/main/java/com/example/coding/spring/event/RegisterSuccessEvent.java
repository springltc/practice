package com.example.coding.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author liutc
 * @date 2024/4/19 13:28
 */
public class RegisterSuccessEvent extends ApplicationEvent {

    public RegisterSuccessEvent(RegisterInfo registerInfo) {
        super(registerInfo);
    }
}
