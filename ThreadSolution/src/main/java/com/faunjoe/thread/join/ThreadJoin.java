package com.faunjoe.thread.join;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-15 15:36
 */
public class ThreadJoin {

    public static void main(String[] args){

        Thread t1 = new Thread(()->{
            IntStream.range(1,1000).forEach(i->{
                System.out.println(Thread.currentThread().getName() + "->"+i);
            });
        });

        Thread t2 = new Thread(()->{
            IntStream.range(1,1000).forEach(i->{
                System.out.println(Thread.currentThread().getName() + "->"+i);
            });
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Optional.of("All of tasks finish done.").ifPresent(System.out::println);

        IntStream.range(1,1000).forEach(i->{
            System.out.println(Thread.currentThread().getName() + "->"+i);
        });
    }
}
