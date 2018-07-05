package com.faunjoe;


import com.faunjoe.service.UserService;
import com.faunjoe.spring.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("com.faunjoe.impl");
		UserService userService = (UserService) app.getBean("userServiceImpl");
		userService.add();
	}

}
