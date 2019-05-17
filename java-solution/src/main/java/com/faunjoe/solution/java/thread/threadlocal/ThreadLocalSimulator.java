package com.faunjoe.solution.java.thread.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * 始终以当前线程作为key值。
 *
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-01 11:46
 */
public class ThreadLocalSimulator<T> {

    private final Map<Thread, T> storage = new HashMap<>();

    public void set(T t) {
        synchronized (this) {
            Thread key = Thread.currentThread();
            storage.put(key, t);
        }
    }

    public T get() {
        synchronized (this) {
            Thread key = Thread.currentThread();
            T value = storage.get(key);
            if (value == null) {
                return initialValue();
            }
            return value;
        }
    }

    private T initialValue() {
        return null;
    }
}
