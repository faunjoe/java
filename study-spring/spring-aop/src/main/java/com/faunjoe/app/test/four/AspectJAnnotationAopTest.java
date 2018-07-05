package com.faunjoe.app.test.four;


import com.faunjoe.app.config.AppConfig;
import com.faunjoe.app.entity.ChromeBrowser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class AspectJAnnotationAopTest {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ChromeBrowser browser = (ChromeBrowser) context.getBean("chromeBrowser");
		//browser.visitInternet();
		//browser.listenToMusic();
		//browser.seeMovie("The Great Wall", new Date(), "Jack");
		browser.seeMovie("The Great Wall", new Date(), "Jack");
	}
}
