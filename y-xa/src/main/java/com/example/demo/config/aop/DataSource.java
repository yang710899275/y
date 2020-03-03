package com.example.demo.config.aop;

import java.lang.annotation.*;

/**
 * 多数据源切换标识
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface DataSource {

    String name() default "";
}
