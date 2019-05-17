package com.faunjoe.solution.java.designpattern.future;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-01 00:19
 */
public interface Future<T> {

    T get() throws InterruptedException;
}
