package com.faunjoe.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/23 14:17
 */
// 在运行时执行
@Retention(RetentionPolicy.RUNTIME)
// 注解适用地方(字段和方法)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ZxfResource {
    //注解的name属性
    public String name() default "";
}
