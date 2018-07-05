package com.faunjoe.app.test.three;


import com.faunjoe.app.entity.Browser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoProxyCreatorAopTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autoproxy-regexp.xml");
        Browser browser = (Browser) context.getBean("chromeBrowser");
        browser.visitInternet();
    }
}
