package com.faunjoe.solution.java;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-22 16:48
 */
public class CallBackTest {

    public int process(CallBack<Person> callBack, Person person) {
        return callBack.onSuccess(person);
    }

    public void test(Person person) {
        process(new CallBack<Person>() {
            @Override
            public int onSuccess(Person object) {
                System.out.println(object.age);
                return 1;
            }
        }, person);
    }

    public static void main(String[] args) {
        CallBackTest test = new CallBackTest();
        Person p = new Person();
        p.age = 10;
        test.test(p);
    }

    abstract class CallBack<T> {
        public abstract int onSuccess(T object);
    }
}
