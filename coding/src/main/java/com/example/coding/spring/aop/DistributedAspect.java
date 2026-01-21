package com.example.coding.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class DistributedAspect {
//    private final StringRedisTemplate stringRedisTemplate;
//
//    public DistributedAspect(StringRedisTemplate stringRedisTemplate) {
//        this.stringRedisTemplate = stringRedisTemplate;
//    }

    @Around("@annotation(function)")
    public Object around(ProceedingJoinPoint point, DistributedLock function) {
        String key = function.system().name() + ":" + AspectUtil.getMarkerValue(point, function.key());
        System.out.println("----------:" + key);
        System.out.println("----------:" + key);
//        Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(key, String.valueOf(System.currentTimeMillis()), Duration.ofSeconds(function.duration()));
//        if (BooleanUtils.isFalse(flag)) {
//            log.warn("未获取到[{}]的使用权限", key);
//            throw ExceptionConstant.TOO_MANY_REQUESTS;
//        }

        try {
            return point.proceed();
        } catch (RuntimeException e) {
//            stringRedisTemplate.delete(key);
            throw e;
        } catch (Throwable throwable) {
//            stringRedisTemplate.delete(key);
            log.warn("系统异常", throwable);
//            throw ExceptionConstant.SYSTEM_ERROR;
            throw new RuntimeException(throwable);
        }
    }
}
