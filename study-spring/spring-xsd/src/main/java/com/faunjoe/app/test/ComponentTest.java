package com.faunjoe.app.test;

import com.faunjoe.app.entity.Component;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("component.xml");
        Component component = context.getBean(Component.class);
        System.out.println(component);
    }
}