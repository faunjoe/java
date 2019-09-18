package com.faunjoe.solution.java.lambda.Optional;

import lombok.Data;
import org.junit.Test;

import java.util.Optional;

/**
 * @author faunjoe
 * @version 创建时间：2019-07-17 13:17
 */
public class OptionalTest {

    @Test
    public void testOptionEmpty() {
        //empty方法的使用
        Optional<Car> optCar = Optional.empty();
        System.out.println(optCar);
    }

    @Test
    public void testOptionOf(){
        Car car = new Car();
        //of方法的使用
        Optional<Car> optCar = Optional.of(car);
        System.out.println(optCar);
    }

    @Test
    public void testOptionofNullable(){
        Car car = null;
        //of方法的使用
        Optional<Car> optCar = Optional.ofNullable(car);
        System.out.println(optCar);
    }

    @Data
    private static class Car {
        private String name;
        private int price;
    }
}
