package com.faunjoe.mvc.framework.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FRequestParam {
	String value() default "";
	
	boolean required() default true;
}
