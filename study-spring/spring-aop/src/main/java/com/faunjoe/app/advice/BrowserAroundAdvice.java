package com.faunjoe.app.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 通过环绕增强统一处理
 * org.aopalliance.intercept.MethodInterceptor,它并不是Spring定义的接口，而是来自AOP联盟提供的API。
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/8 14:32
 */
public class BrowserAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        encrypt();
        Object retVal = invocation.proceed();
        decrypt();
        return retVal;
    }

    /**
     * 加密
     */
    private void encrypt() {
        System.out.println("encrypt ...");
    }

    /**
     * 解密
     */
    private void decrypt() {
        System.out.println("decrypt ...");
    }
}
