package com.faunjoe.thread.join;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-15 15:36
 */
public class ThreadJoin2 {

    public static void main(String[] args){

        try {
            //自己等自己结束，永远结束不了。
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
