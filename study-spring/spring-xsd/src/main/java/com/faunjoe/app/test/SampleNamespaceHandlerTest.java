package com.faunjoe.app.test;

import com.faunjoe.app.entity.SampleBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleNamespaceHandlerTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("namespace-handler.xml");
		SampleBean sampleBean = context.getBean("sampleBean",SampleBean.class);
		sampleBean.print();
	}
}
