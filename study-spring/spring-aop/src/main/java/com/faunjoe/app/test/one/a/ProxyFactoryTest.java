package com.faunjoe.app.test.one.a;

import com.faunjoe.app.advice.BrowserAfterReturningAdvice;
import com.faunjoe.app.advice.BrowserBeforeAdvice;
import com.faunjoe.app.entity.Browser;
import com.faunjoe.app.entity.ChromeBrowser;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 通过代理 添加前置和后置增强
 *
 * @author faunjoe
 */
public class ProxyFactoryTest {

    public static void main(String[] args) {
        // 1.创建代理工厂 Spring AOP最原始也是最底层的方式ProxyFactory
        ProxyFactory factory = new ProxyFactory();
        // 2.设置目标对象
        factory.setTarget(new ChromeBrowser());
        // 3.设置代理实现接口
        factory.setInterfaces(new Class[]{Browser.class});
        // 4.添加前置增强
        factory.addAdvice(new BrowserBeforeAdvice());
        // 5.添加后置增强
        factory.addAdvice(new BrowserAfterReturningAdvice());
        // 6.获取代理对象
        Browser browser = (Browser) factory.getProxy();

        browser.visitInternet();
        System.out.println("---------------------------");
        browser.listenToMusic();
    }
}
