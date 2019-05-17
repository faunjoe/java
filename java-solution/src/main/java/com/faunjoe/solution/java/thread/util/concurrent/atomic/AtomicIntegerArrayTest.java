package com.faunjoe.solution.java.thread.util.concurrent.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;

import static org.junit.Assert.assertEquals;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-04 01:00
 */
public class AtomicIntegerArrayTest {

    @Test
    public void testCreateAtomicIntegerArray(){
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        assertEquals(10,array.length());
    }

    @Test
    public void testGet(){
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        assertEquals(10,array.length());
        assertEquals(0,array.get(5));
    }

    @Test
    public void testSet(){
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        array.set(5,5);
        assertEquals(10,array.length());
        assertEquals(5,array.get(5));
    }

    @Test
    public void testGetAndSet(){
        int[] originalArray = new int[10];
        AtomicIntegerArray array = new AtomicIntegerArray(originalArray);
        array.set(5,5);
        assertEquals(10,array.length());
        assertEquals(5,array.get(5));
    }
}
