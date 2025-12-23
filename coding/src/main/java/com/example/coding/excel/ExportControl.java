package com.example.coding.excel;

/**
 * @author liutc
 * @date 2025/12/23 17:42
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 控制字段是否导出的注解
 * 加在字段上，优先级最高
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExportControl {

    /**
     * 是否导出该字段
     * true: 导出, false: 不导出
     * 默认导出
     */
    boolean export() default true;

    /**
     * 导出条件：SPEL表达式
     * 例如: "#value != null && #value != ''"
     */
    String condition() default "";
}
