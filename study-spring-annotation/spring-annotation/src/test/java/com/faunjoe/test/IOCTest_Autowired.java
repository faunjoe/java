package com.faunjoe.test;

import com.faunjoe.config.MainConifgOfAutowired;
import com.faunjoe.dao.BookDao;
import com.faunjoe.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConifgOfAutowired.class);
		
		BookService bookService = applicationContext.getBean(BookService.class);
		System.out.println(bookService);
		
		BookDao bean = applicationContext.getBean(BookDao.class);
		System.out.println(bean);
		

		applicationContext.close();
	}

}
