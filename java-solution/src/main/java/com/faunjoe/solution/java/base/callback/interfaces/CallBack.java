package com.faunjoe.solution.java.base.callback.interfaces;

public abstract class CallBack<T,V> {
    public abstract V onSuccess(T object);
}