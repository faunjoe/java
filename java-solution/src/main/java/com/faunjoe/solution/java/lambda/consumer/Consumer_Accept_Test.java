package com.faunjoe.solution.java.lambda.consumer;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-28 13:16
 */
public class Consumer_Accept_Test {

    @Data
    @AllArgsConstructor
    public class Person {
        private int age;
        private String name;
    }

    public List<Person> getList() {
        return Stream.of(
                new Person(21, "zhangsan"),
                new Person(22, "lisa"),
                new Person(23, "wangwu"),
                new Person(24, "wangwu"),
                new Person(23, "lisa"),
                new Person(26, "lisa"),
                new Person(26, "zhangsan")
        ).collect(Collectors.toList());
    }

    /**
     * 比如将给定的一批用户里面的名称为"lisa"的用户都给打包起来
     */
    @Test
    public void testConsumer() {
        List<Person> list = new ArrayList<>();

        Consumer<Person> consumer = x -> {
            if (x.getName().equals("lisa")) {
                list.add(x);
            }
        };

        getList().forEach(consumer);

        System.out.println(JSON.toJSONString(list));
    }

    /**
     * 比如将给定的一批用户里面的名称为"lisa"且年龄大于22岁的用户都给打包起来
     */
    @Test
    public void testConsumerAndThen() {
        List<Person> list = new ArrayList<>();

        Consumer<Person> consumer = x -> {
            if (x.getName().equals("lisa")) {
                list.add(x);
            }
        };

        consumer = consumer.andThen(x -> list.removeIf(y -> y.getAge() < 23));

        getList().forEach(consumer);

        System.out.println(JSON.toJSONString(list));
    }

    /**
     * 接受一个输入参数，无返回值
     */
    @Test
    public void testConsumerAccept() {
        Consumer<String> consumer = (x) -> System.out.println("consumer: " + x);
        consumer.accept("Hello");
    }
}
