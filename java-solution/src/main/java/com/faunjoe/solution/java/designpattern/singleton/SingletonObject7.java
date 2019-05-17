package com.faunjoe.solution.java.designpattern.singleton;

import java.util.stream.IntStream;

/**
 * 枚举方式。利用枚举的特性
 *
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-28 23:35
 */
public class SingletonObject7 {

    private SingletonObject7() {
    }

    private enum Singleton {
        INSTANCE;

        private final SingletonObject7 instance;

        Singleton() {
            instance = new SingletonObject7();
        }

        public SingletonObject7 getInstance() {
            return instance;
        }
    }

    public static SingletonObject7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(i -> new Thread(String.valueOf(i)) {
            @Override
            public void run() {
                System.out.println(SingletonObject7.getInstance());
            }
        }.start());
    }
}

