package com.faunjoe.solution.java.thread.threadlocal.context1;

import com.faunjoe.solution.java.thread.threadlocal.context.Context;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-01 12:19
 */
public class QueryFromHttpAction {

    public void execute() {
        Context context = ActionContext.getActionContext().getContext();
        String name = context.getName();
        String cardId = getCardId(name);
        context.setCardId(cardId);
    }

    private String getCardId(String name) {

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "123123123" + Thread.currentThread().getId();
    }
}
