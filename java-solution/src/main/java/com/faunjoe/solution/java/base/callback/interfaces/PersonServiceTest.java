package com.faunjoe.solution.java.base.callback.interfaces;


import org.junit.Test;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-24 11:09
 */
public class PersonServiceTest {

    @Test
    public void testPersonService() {
        Person person = new Person();
        person.setAge(30);
        person.setName("faunjoe");

        PersonServiceImpl personService = new PersonServiceImpl();

        PersonData data = personService.onProcess(new CallBack<Person, PersonData>() {
            @Override
            public PersonData onSuccess(Person object) {
                PersonData data = new PersonData();
                data.setAge(object.getAge());
                data.setName(object.getName());

                return data;
            }
        }, person);

        System.out.println(data);
    }
}
