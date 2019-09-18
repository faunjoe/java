package com.faunjoe.solution.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-13 11:33
 */
public class CommonTest {

    @Test
    public void TestArraysAsList() {
        String ipStr = "127.0.0.1:8080";
        List<String> strings = Arrays.asList(ipStr.split(":"));
        System.out.println(strings);
    }
}
