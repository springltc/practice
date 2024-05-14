package com.example.coding.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author liutc
 * @date 2024/4/19 13:29
 */
@Component
public class RegisterEventListener {

    @EventListener(RegisterSuccessEvent.class)
    public void onApplicationEvent(RegisterSuccessEvent event) {
        RegisterInfo registerInfo = (RegisterInfo) event.getSource();

        //执行发送欢迎短信的逻辑
        System.out.println("=======执行事件:" + registerInfo.getMessage());
    }
}
