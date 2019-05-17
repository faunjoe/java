package com.faunjoe.solution.java.designpattern.immutable;

import java.util.stream.IntStream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-31 22:51
 */
public class ImmutableClient {

    public static void main(String[] args) {
        //Share data
        Person person = new Person("faunjoe", "HuBei");


        IntStream.range(0, 5).forEach(i ->
                new UsePersonThread(person).start());
    }
}
