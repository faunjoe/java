package com.faunjoe.solution.java.base.callback.interfaces;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-24 10:57
 */
public interface PersonService<T,V> {

    public V onProcess(CallBack<T,V> callBack,T t);
}