package com.faunjoe.app.proxy;

import com.faunjoe.app.entity.Game;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * CGLIB引入增强
 * 实现原理就以下几步：
 * 1.通过CGLIB创建代理对象，并使其实现指定接口
 * 2.在MethodIntercept的回调方法中，判断执行方法是否为接口中的方法，如果是，则通过反射调用接口的实现类。
 * 代理类实现Game接口，并在intercept方法中判断执行方法是接口方法还是原对象的方法
 */
public class CglibIntroductionBrowserProxy implements MethodInterceptor, Game {

    private static CglibIntroductionBrowserProxy proxy = new CglibIntroductionBrowserProxy();

    private CglibIntroductionBrowserProxy() {

    }

    public static CglibIntroductionBrowserProxy getInstance() {
        return proxy;
    }

    public <T> T getProxy(Class<T> clazz) {
        return (T) Enhancer.create(clazz, new Class[]{Game.class}, this);
    }

    /**
     * cglib中的callback通过实现它的MethodInterceptor接口的intercept方法
     *
     * @param obj    obj是被代理的对象
     * @param method method是执行的方法
     * @param args   args是执行方法的参数数组
     * @param proxy  proxy用来执行未被拦截的原方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object retVal;
        encrypt();
        // 判断执行方法是接口方法还是原对象的方法
        if (method.getDeclaringClass().isInterface()) {
            method.setAccessible(true);
            // 发现执行接口方法时，通过jdk的反射机制来实现的
            retVal = method.invoke(this, args);
        } else {
            // 调用其自身方法，则是通过cglib来触发的
            retVal = proxy.invokeSuper(obj, args);
        }
        decrypt();
        return retVal;
    }

    @Override
    public void start() {
        System.out.println("start a game");
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
