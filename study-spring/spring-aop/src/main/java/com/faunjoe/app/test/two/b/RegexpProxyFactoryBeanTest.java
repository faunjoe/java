package com.faunjoe.app.test.two.b;

import com.faunjoe.app.entity.ChromeBrowser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;


public class RegexpProxyFactoryBeanTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("proxyfactorybean-regexp.xml");
        ChromeBrowser browser = (ChromeBrowser) context.getBean("browserProxy");
        browser.seeMovie("The Great Wall", new Date(), "Jack");
    }
}
