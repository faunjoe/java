package com.faunjoe.solution.java.apache.commons;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Optional;

/**
 * @author faunjoe
 * @version 创建时间：2019-05-17 11:55
 */
public class StringUtilsTest {

    @Test
    public void testIsNotEmpty(){
        String str1 = null;
        String str2 = "";
        String str3 = "faunjoe";

        if(StringUtils.isNotEmpty(str1)){
            System.out.println(str1);
        }
        if(StringUtils.isNotEmpty(str2)){
            System.out.println(str2);
        }
        if(StringUtils.isNotEmpty(str3)){
            System.out.println(str3);
            System.out.println(Optional.ofNullable(str1));
        }
    }
}
