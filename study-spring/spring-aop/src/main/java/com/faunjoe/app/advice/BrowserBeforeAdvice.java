package com.faunjoe.app.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 浏览器前置增强
 *
 * @author faunjoe
 */
public class BrowserBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        encrypt();
    }

    /**
     * 加密
     */
    private void encrypt() {
        System.out.println("encrypt ...");
    }

}
