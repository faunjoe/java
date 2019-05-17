package com.faunjoe.solution.java.thread.customlock;

import javax.naming.Name;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-20 00:40
 */
public class BooleanLockTest {

    public static void main(String[] args) throws InterruptedException {
        final BooleanLock booleanLock = new BooleanLock();

        Stream.of("T1", "T2", "T3", "T4")
                .forEach(name -> new Thread(() -> {
                            try {
                                booleanLock.lock(10L);
                                Optional.of(Thread.currentThread().getName() + " have the lock monitor")
                                        .ifPresent(System.out::println);
                                work();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (Lock.TimeOutException e) {
                                System.out.println(e.getMessage());
                            } finally {
                                booleanLock.unlock();
                            }
                        }, name).start()
                );
        Thread.sleep(100);
    }

    private static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName() + " is working...")
                .ifPresent(System.out::println);

        Thread.sleep(1000);
    }
}
