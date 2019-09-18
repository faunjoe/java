package com.faunjoe.solution.java.tool.lombok;

import lombok.NonNull;
import org.junit.Test;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-02 10:57
 */
public class TestNonNull {

    public void nonNullDemo1(Employee employee, Account account) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee is marked @NonNull but is null");
        }

        if (account == null) {
            throw new IllegalArgumentException("Account is marked @NonNull but is null");
        }
    }

    @Test
    public void TestNonNullDemo1(){
        nonNullDemo1(null,null);
    }


    public void nonNullDemo(@NonNull Employee employee, @NonNull Account account) {

    }

    @Test
    public void TestNonNullDemo2(){
        nonNullDemo(null,null);
    }
}
