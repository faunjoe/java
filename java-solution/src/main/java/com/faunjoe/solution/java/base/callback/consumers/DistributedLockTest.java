package com.faunjoe.solution.java.base.callback.consumers;

import com.faunjoe.solution.java.base.callback.interfaces.Person;
import org.junit.Test;

import java.util.function.Consumer;


/**
 * @author faunjoe
 * @version 创建时间：2019-06-28 11:55
 */
public class DistributedLockTest {

    @Test
    public void distributedLock() {
        DistributedLockService service = new DistributedLockService();
        Person p = new Person();
        p.setAge(30);
        p.setName("aijun.fu");

        Consumer<Person> consumer = x -> System.out.println("consumer: " + x);
        service.distributedLock("", 0, consumer, p);
        service.distributedLock("", 0, (x) -> System.out.println(x), p);
    }
}
