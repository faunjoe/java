package com.faunjoe.app.test.one.b;

import com.faunjoe.app.advice.BrowserAroundAdvice;
import com.faunjoe.app.entity.Browser;
import com.faunjoe.app.entity.ChromeBrowser;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/8 14:35
 */
public class RegexpProxyFactoryTest {
    public static void main(String[] args) {
        // 1.创建代理工厂
        ProxyFactory factory = new ProxyFactory();
        // 2.设置目标对象
        factory.setTarget(new ChromeBrowser());
        // 3.设置代理实现接口
        factory.setInterfaces(new Class[]{Browser.class});
        // 4.创建正则表达式切面类
        RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
        // 5.添加环绕增强
        advisor.setAdvice(new BrowserAroundAdvice());
        // 6.设置切入点正则表达式  只想对visitInternet进行代理
        advisor.setPattern("com.faunjoe.app.entity.ChromeBrowser.visitInternet");
        // 7.工厂增加切面
        factory.addAdvisor(advisor);
        // 8.获取代理对象
        Browser browser = (Browser) factory.getProxy();

        System.out.println("---------------------------");
        // 被代理
        browser.visitInternet();

        // 没有被代理
        browser.listenToMusic();
    }
}
