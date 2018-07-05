package com.faunjoe.test.bean;

/**
 * Company
 * @author faunjoe
 */
public class Company {

    private String name;
    
    private Employee employee;
    
    public void open(){
        System.out.println("Company " + name + " is open.");
        employee.work();
    }
}
