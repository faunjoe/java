package com.faunjoe.demo.springbootstart;

import com.faunjoe.demo.springbootstart.event.MsgEvent;
import com.faunjoe.demo.springbootstart.event.PrintListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


public class SpringBootStartApplication1 {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringBootStartApplication.class);
		springApplication.setWebEnvironment(true);
		//配置事件监听
		//springApplication.addListeners(new PrintListener());
		//配置事件监听
		ConfigurableApplicationContext context = springApplication.run(args);
		//发布事件
		//context.publishEvent(new MsgEvent(new Object(),"hello world."));
	}
}
