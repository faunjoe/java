package com.faunjoe.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/16 15:19
 */
public class TestCar {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("annotation-bean.xml");

        // Car
        // 当调用getBean("car")时，Spring通过反射机制发现CarFactoryBean实现了FactoryBean的接口，
        // 这时Spring容器就调用接口方法CarFactoryBean#getObject()方法返回。
        System.out.println(context.getBean("car"));

        // CarFactoryBean
        // 如果希望获取CarFactoryBean的实例，则需要在使用getBean(beanName)方法时在beanName前显示的加上"&"前缀：如getBean("&car")
        System.out.println(context.getBean("&car"));

    }
}
