package com.faunjoe.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 注解适用地方(字段和方法)
@Target({ElementType.FIELD, ElementType.METHOD})
// 在运行时执行
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtResource {
    //注解的name属性
    String name() default "";
}
