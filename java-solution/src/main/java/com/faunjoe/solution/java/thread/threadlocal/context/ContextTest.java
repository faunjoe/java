package com.faunjoe.solution.java.thread.threadlocal.context;

import java.util.stream.IntStream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-01 12:27
 */
public class ContextTest {

    public static void main(String[] args) {

        IntStream.range(1, 5)
                .forEach(i ->
                        new Thread(new ExecutionTask()).start()
                );
    }
}
