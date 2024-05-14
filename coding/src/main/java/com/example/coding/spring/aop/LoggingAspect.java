package com.example.coding.spring.aop;

/**
 * @author liutc
 * @date 2024/4/19 11:26
 */
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.coding.spring.aop.MyService.doSomething())")
    public void beforeAdvice() {
        System.out.println("Before method execution");
    }
}

