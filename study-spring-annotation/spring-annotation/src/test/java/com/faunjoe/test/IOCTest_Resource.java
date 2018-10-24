package com.faunjoe.test;


import com.faunjoe.config.MainConifgOfResource;
import com.faunjoe.dao.OrderDao;
import com.faunjoe.service.OrderService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Resource {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MainConifgOfResource.class);

		OrderService orderService = applicationContext.getBean(OrderService.class);
		System.out.println(orderService);

		OrderDao bean = (OrderDao)applicationContext.getBean("orderDao2");
		System.out.println(bean);
		

		applicationContext.close();
	}

}
