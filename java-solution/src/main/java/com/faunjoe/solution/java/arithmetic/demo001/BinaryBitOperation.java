package com.faunjoe.solution.java.arithmetic.demo001;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author faunjoe
 * @version 创建时间：2019-07-04 10:23
 */
@Slf4j
public class BinaryBitOperation {

    @Test
    public void testViolenceMethod() {
        int t = 0;
        //得到二进制表示
        String binaryString = Integer.toBinaryString(99);
        log.info("99 binary {}", binaryString);
        char[] ch = binaryString.toCharArray();
        //从左到右遍历
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '1') {
                t++;
            }
        }
        log.info("result {}", t);
    }

    @Test
    public void testBitOperation() {
        int count = 0;
        int n = 99;
        //只要不等于0
        while (n != 0) {
            log.info("n: {} binary {}", n, Integer.toBinaryString(n));
            log.info("n-1: {} binary {}", n - 1, Integer.toBinaryString(n - 1));
            ++count;
            //进行一次位运算操作
            n = n & (n - 1);
            log.info("n & (n - 1) : {}", n);
        }
        log.info("count : {}", count);
    }
}
