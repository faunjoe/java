package com.faunjoe.solution.java.lambda.predicate;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-28 13:37
 */
public class PredicateTest {

    @Test
    public void testPredicate() {
        Predicate<String> predicate = (x) -> x.length() > 0;
        System.out.println(predicate.test("String"));
    }
}
