package com.faunjoe.app.test;

import com.faunjoe.app.entity.JobDetailTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;

import java.text.SimpleDateFormat;

public class MyNsTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/myns.xml");
        JobDetailTemplate jobDetailTemplate = context.getBean(JobDetailTemplate.class);

        SimpleDateFormat dateFormat = jobDetailTemplate.getDateFormat();
        System.out.println(dateFormat.toPattern());
        String pattern = (String) ReflectionTestUtils.getField(dateFormat, "pattern");
        System.out.println(pattern);
    }
}