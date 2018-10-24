package com.faunjoe.beans;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 13:50
 */
public class Person {

    public Person() {

    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    //使用@Value赋值；
    //1、基本数值
    //2、可以写SpEL； #{}
    //3、可以写${}；取出配置文件【properties】中的值（在运行环境变量里面的值）

    @Value("张三")
    private String name;
    @Value("#{20-2}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;



    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
