package com.faunjoe.test;



import com.faunjoe.tx.TxConfig;
import com.faunjoe.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Tx {
	
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(TxConfig.class);

		UserService userService = applicationContext.getBean(UserService.class);

		userService.insertUser();
		applicationContext.close();
	}

}
