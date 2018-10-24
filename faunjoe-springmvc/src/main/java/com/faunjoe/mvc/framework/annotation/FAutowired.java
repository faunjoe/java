package com.faunjoe.mvc.framework.annotation;

import java.lang.annotation.*;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FAutowired {
	String value() default "";
}
