package com.faunjoe;


import com.faunjoe.entity.User;
import com.faunjoe.spring.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		User user = (User) applicationContext.getBean("user");
		System.out.println(user);
	}

}
