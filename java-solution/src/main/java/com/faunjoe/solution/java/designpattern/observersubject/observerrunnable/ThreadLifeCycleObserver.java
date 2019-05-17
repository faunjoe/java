package com.faunjoe.solution.java.designpattern.observersubject.observerrunnable;


import java.util.List;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-30 23:13
 */
public class ThreadLifeCycleObserver implements LifeCycleListener {

    private final Object LOCK = new Object();

    public void conCurrentQuery(List<String> ids) {
        if (ids == null || ids.isEmpty())
            return;

        ids.stream().forEach(id -> new Thread(new ObservableRunnable(this) {
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                    System.out.println("query for this id " + id);
                    Thread.sleep(1000L);
                    //int i = 1 / 0;
                    notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                } catch (Exception e) {
                    notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
                }
            }
        }, id).start());
    }

    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized (LOCK) {
            System.out.println("The runnable [" + event.getThread()
                    .getName() + "] data changed and state is [" + event.getState() + "]");

            if(event.getCause() != null){
                System.out.println("The runnable ["+event.getThread().getName()+"] process failed.");
                event.getCause().printStackTrace();
            }
        }
    }
}
