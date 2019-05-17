package com.faunjoe.solution.java.thread.threadlocal.context1;

import com.faunjoe.solution.java.thread.threadlocal.context.Context;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-01-01 20:32
 */
public class ActionContext {

    private static final ThreadLocal<Context> THREAD_LOCAL = new ThreadLocal<Context>() {
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    private static class ContextHolder {
        private final static ActionContext ACTION_CONTEXT = new ActionContext();
    }

    public static ActionContext getActionContext() {
        return ContextHolder.ACTION_CONTEXT;
    }

    public Context getContext() {
        return THREAD_LOCAL.get();
    }


}
