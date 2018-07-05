package com.faunjoe.app.test.two.a;

import com.faunjoe.app.entity.Browser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/8 14:45
 */
public class ProxyFactoryBeanTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("proxyfactorybean.xml");
        Browser browser = (Browser) context.getBean("browserProxy");
        browser.visitInternet();
        System.out.println("-----------------");
        browser.listenToMusic();
    }
}
