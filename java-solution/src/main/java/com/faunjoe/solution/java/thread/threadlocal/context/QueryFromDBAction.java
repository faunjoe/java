package com.faunjoe.solution.java.thread.threadlocal.context;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-01 12:11
 */
public class QueryFromDBAction {

    public void execute(Context context) {
        try {
            Thread.sleep(1000L);
            String name = "faunjoe" + Thread.currentThread().getName();
            context.setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
