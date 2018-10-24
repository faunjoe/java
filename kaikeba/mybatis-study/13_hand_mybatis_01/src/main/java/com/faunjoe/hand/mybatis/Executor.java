package com.faunjoe.hand.mybatis;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 00:08
 */
public interface Executor {

    <E> E query(String statement, Object parameter);
}
