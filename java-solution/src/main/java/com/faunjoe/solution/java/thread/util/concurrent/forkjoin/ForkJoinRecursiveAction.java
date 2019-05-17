package com.faunjoe.solution.java.thread.util.concurrent.forkjoin;

import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 有返回值
 *
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-28 01:35
 */
public class ForkJoinRecursiveAction {

    private final static int MAX_THRESHOLD = 3;

    private final static AtomicInteger SUM = new AtomicInteger(0);

    private static class CalculatedRecursiveAction extends RecursiveAction {

        private final int start;

        private final int end;

        private CalculatedRecursiveAction(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if ((end - start) <= MAX_THRESHOLD) {
                SUM.addAndGet(IntStream.rangeClosed(start, end).sum());
            } else {
                int middle = (start + end) / 2;
                CalculatedRecursiveAction leftAction = new CalculatedRecursiveAction(start, middle);
                CalculatedRecursiveAction rightAction = new CalculatedRecursiveAction(middle + 1, end);
                leftAction.fork();
                rightAction.fork();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.submit(new CalculatedRecursiveAction(0, 100));

        forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);

        Optional.of(SUM).ifPresent(System.out::println);

    }
}
