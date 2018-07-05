package com.faunjoe.app.proxy;

import com.faunjoe.app.entity.Browser;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * 在JDK中提供了一种代理的实现方式，可以动态地创建代理类，就是java.lang.reflect包中的Proxy类提供的newProxyInstance方法。
 *
 * @author faunjoe
 */
public class JdkBrowserProxy implements InvocationHandler {

    private Browser browser;

    public JdkBrowserProxy(Browser browser) {
        this.browser = browser;
    }

    /**
     * getProxy
     *
     * @return
     */
    public Object getProxy() {

        /**
         * Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
         * classLoader是创建代理类的类加载器
         * interfaces是原对象实现的接口
         * InvocationHandler是回调方法的接口
         */
        return Proxy.newProxyInstance(browser.getClass().getClassLoader(),
                browser.getClass().getInterfaces(), this);
    }

    /**
     * invoke
     *
     * @param proxy  proxy是代理对象，一般情况下，在invoke 方法中都不使用该对象
     * @param method method是执行的方法
     * @param args   args是执行方法的参数数组
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        encrypt();
        Object retVal = method.invoke(browser, args);
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
