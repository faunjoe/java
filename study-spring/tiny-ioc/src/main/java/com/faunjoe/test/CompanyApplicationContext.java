package com.faunjoe.test;


import com.faunjoe.ioc.context.ApplicationContext;
import com.faunjoe.ioc.context.ClasspathXmlApplicationContext;
import com.faunjoe.test.bean.Company;

public class CompanyApplicationContext {

    public static void main(String[] args) {
        ApplicationContext context = new ClasspathXmlApplicationContext("company-ioc.xml");
        Company company = (Company) context.getBean("company");
        company.open();
    }
}
