package com.faunjoe.solution.java.thread.threadlocal.context1;


import com.faunjoe.solution.java.thread.threadlocal.context.Context;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-01 12:09
 */
public class ExecutionTask implements Runnable {

    private QueryFromDBAction queryFromDBAction = new QueryFromDBAction();

    private QueryFromHttpAction queryFromHttpAction = new QueryFromHttpAction();

    @Override
    public void run() {
        Context context = ActionContext.getActionContext().getContext();
        queryFromDBAction.execute();
        System.out.println("The Name query successful");
        queryFromHttpAction.execute();
        System.out.println("The CardId query successful");
        System.out.println("The Name is " + context.getName() + " and CardId " + context.getCardId());
    }
}
