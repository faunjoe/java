package com.faunjoe.solution.java;

import java.util.HashMap;
import java.util.Random;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-03-08 11:19
 */
public class test {
    public static void main(String[] args) {
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        map.put(System.nanoTime(), System.currentTimeMillis());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

}
