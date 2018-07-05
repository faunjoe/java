package com.segmentfault.spring.ioc.validator;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * <p>todo</p>
 *
 * @author zhaoyong
 * @version $Id: CustomPathVariable , v 0.1  K555 Exp $
 * @date 2017年11月07 12:12
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomPathVariable {

    @AliasFor("name")
    String value() default "";

    @AliasFor("value")
    String name() default "";

    boolean required() default true;

}
