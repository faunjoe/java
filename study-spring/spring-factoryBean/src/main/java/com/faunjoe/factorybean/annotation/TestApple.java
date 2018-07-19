package com.faunjoe.factorybean.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/16 15:51
 */
public class TestApple {

    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configurations.class);
        System.out.println(applicationContext.getBean("appleFactoryBean"));//得到的是apple
        System.out.println(applicationContext.getBean("&appleFactoryBean"));//得到的是apple工厂
    }
}
