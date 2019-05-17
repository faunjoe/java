package com.springboot.example.springboot15.demo.controller;

import com.springboot.example.springboot15.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/11/22 17:08
 */

@RestController
public class PersonController implements EnvironmentAware {

    @Autowired
    @Qualifier("person")
    private Person person;

    @Value("${person.id}")
    private Long id;

    @Value("${person.name:faunjoe}")
    private String name;

    private Integer age;


    @GetMapping(path = "/person/f1", produces = MediaType.APPLICATION_JSON_VALUE)

    public Person xiaomage() {
        return person;
    }

    @GetMapping(path = "/person/f2", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> xiaomageData() {

        Map<String, Object> data = new LinkedHashMap<>();

        data.put("id", id);
        data.put("name", name);
        data.put("age", age);

        return data;
    }

    @Override
    public void setEnvironment(Environment environment) {

        this.age = environment.getProperty("person.age", Integer.class);

    }
}
