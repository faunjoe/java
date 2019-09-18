package com.faunjoe.solution.java.base.callback.consumers;

import java.util.function.Consumer;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-28 11:55
 */
public class DistributedLockService {
    /**
     * 分布式锁，警告：如果执行时间过长，大于超时时间后，会存在并行执行的情况
     *
     * @param redisKey    要lock的key
     * @param lockSeconds 超时时间
     * @param func        回调函数
     * @param t           回调参数
     * @param <T>         回调参数类型
     * @return 是否拿到锁并执行了回调函数
     */
    public <T> boolean distributedLock(String redisKey, int lockSeconds, Consumer<T> func, T t) {

        func.accept(t);
        return false;
    }
}
