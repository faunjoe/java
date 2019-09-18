package com.faunjoe.solution.java.lambda.function;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-28 13:39
 */
public class FunctionTest {

    @Test
    public void testFunction(){
        Function<Integer, String> function1 = (x) -> "result: " + x;
        System.out.println(function1.apply(6));
    }
}
