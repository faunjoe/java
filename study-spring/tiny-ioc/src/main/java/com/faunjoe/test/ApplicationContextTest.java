package com.faunjoe.test;


import com.faunjoe.ioc.context.ApplicationContext;
import com.faunjoe.ioc.context.ClasspathXmlApplicationContext;

public class ApplicationContextTest {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClasspathXmlApplicationContext("classpath:tinyioc.xml");
		HelloWorldService helloWorldService = (HelloWorldService)context.getBean("helloWorldService");
		helloWorldService.helloworld();
		helloWorldService.invokeReference();
	}
}
