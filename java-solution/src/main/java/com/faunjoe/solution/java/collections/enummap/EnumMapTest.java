package com.faunjoe.solution.java.collections.enummap;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-19 14:06
 */
public class EnumMapTest {

    public static void main(String[] args){
        EnumMap<Course, String> map = new EnumMap<Course, String>(Course.class);
        map.put(Course.ONE, "语文");
        map.put(Course.ONE, "政治");
        map.put(Course.TWO, "数学");
        map.put(Course.THREE, "英语");
        for(Map.Entry<Course, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
