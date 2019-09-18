package com.faunjoe.solution.java.base.callback.interfaces;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-24 11:01
 */
public class PersonServiceImpl implements PersonService<Person, PersonData> {

    @Override
    public PersonData onProcess(CallBack<Person, PersonData> callBack, Person person) {
        return callBack.onSuccess(person);
    }
}
