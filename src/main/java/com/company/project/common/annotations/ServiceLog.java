package com.company.project.common.annotations;

import java.lang.annotation.*;

/**
 * AOP日志记录，自定义注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLog {

    /**
     * 日志描述
     */
    String description()  default "";
}
