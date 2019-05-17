package com.springboot.example.springboot15.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;


public class Application2 {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringBootConfiguration.class);
		//非web
		springApplication.setWebEnvironment(false);
		springApplication.run(args);
	}
}
