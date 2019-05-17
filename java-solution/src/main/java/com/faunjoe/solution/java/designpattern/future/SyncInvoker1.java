package com.faunjoe.solution.java.designpattern.future;

/**
 * Future           ->代表的是未来的一个凭据
 * FutureTask       ->将你的调用逻辑进行了隔离
 * FutureService    ->桥接 Future 和 FutureTask
 * 这种不用等，执行完通知我。
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-01 00:18
 */
public class SyncInvoker1 {

    public static void main(String[] args) throws InterruptedException {
        FutureService futureService = new FutureService();
        Future<String> future = futureService.submit(() -> {
            try {
                Thread.sleep(10000L);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        },System.out::println);

        System.out.println("==================");
        System.out.println(" do other thing. ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("==================");

    }
}
