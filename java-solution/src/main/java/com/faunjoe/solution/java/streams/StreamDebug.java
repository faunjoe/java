package com.faunjoe.solution.java.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-19 11:08
 */
public class StreamDebug {

    public static void main(String[] args) {
        List<String> list = Stream.of("C", "A", "B")
                .sorted()
                .collect(Collectors.toList());
    }
}
