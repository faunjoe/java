package com.faunjoe.app.test.four;

import com.faunjoe.app.entity.ChromeBrowser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJXmlAopTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aspectj-aop.xml");
		ChromeBrowser browser = (ChromeBrowser) context.getBean("chromeBrowser");
		browser.visitInternet();
		browser.seeMovie("The Great Wall", new java.sql.Date(System.currentTimeMillis()), "Jack");
		browser.seeMovie2("The Great Wall", System.currentTimeMillis(), "Jack");
	}
}
