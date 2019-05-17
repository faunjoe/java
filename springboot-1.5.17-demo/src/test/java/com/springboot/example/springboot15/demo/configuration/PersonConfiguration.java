package com.springboot.example.springboot15.demo.configuration;

import com.springboot.example.springboot15.demo.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/11/23 15:21
 */

@Configuration
public class PersonConfiguration {

    @Bean("primaryPerson")

    public Person person(){
        Person person = new Person();

        person.setAge(30);
        person.setId(1L);
        person.setName("faunjoe");
        return person;
    }
}
