package com.kaikeba;

import com.kaikeba.impl.Dog;
import com.kaikeba.impl.Person;
import com.kaikeba.service.BaseService;
import com.kaikeba.util.ProxyFactory;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/19 14:01
 */
public class TestMain {

    public static void main(String[] args) throws Exception {
        BaseService dog = ProxyFactory.builder(Dog.class);
        dog.eat();//专门负责监控mike的代理对象

        BaseService mike = ProxyFactory.builder(Person.class);
        mike.eat();
    }
}
