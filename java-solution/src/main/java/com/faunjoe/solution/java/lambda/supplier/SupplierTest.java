package com.faunjoe.solution.java.lambda.supplier;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-28 13:34
 */
public class SupplierTest {

    @Test
    public void testSupplier(){
        Supplier<String> supplier = () -> "Test supplier";
        System.out.println(supplier.get());
    }
}
