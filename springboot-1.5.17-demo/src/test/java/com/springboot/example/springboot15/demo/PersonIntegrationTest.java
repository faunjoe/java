package com.springboot.example.springboot15.demo;

import com.springboot.example.springboot15.demo.configuration.PersonConfiguration;
import com.springboot.example.springboot15.demo.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/11/23 15:25
 */

@RunWith(SpringRunner.class)
@ContextHierarchy(
        @ContextConfiguration(
                classes = PersonConfiguration.class
        )
)
public class PersonIntegrationTest {

    @Autowired
    private Person person;

    @Test
    public void testPerson() {
        Assert.assertEquals(Long.valueOf(1L), person.getId());
        Assert.assertEquals("faunjoe", person.getName());
        Assert.assertEquals(30, person.getAge());
    }
}
