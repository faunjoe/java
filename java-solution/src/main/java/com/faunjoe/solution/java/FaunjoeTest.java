package com.faunjoe.solution.java;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-09 18:27
 */

public class FaunjoeTest {
    public static void main(String[] args){
        Date date = new Date();

        LocalDateTime now = LocalDateTime.now();

        System.out.println(date);
        System.out.println(now);
    }
}
