package com.faunjoe.solution.java.designpattern.observersubject.observerrunnable;

import java.util.Arrays;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-30 23:26
 */
public class ThreadLifeCycleClient {

    public static void main(String[] args) {
        new ThreadLifeCycleObserver().conCurrentQuery(Arrays.asList("1", "2"));
    }
}
