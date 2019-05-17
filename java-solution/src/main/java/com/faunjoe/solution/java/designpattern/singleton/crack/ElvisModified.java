package com.faunjoe.solution.java.designpattern.singleton.crack;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-03-01 18:05
 */
public class ElvisModified {

    private static boolean flag = false;

    private ElvisModified(){
        synchronized (ElvisModified.class){
            if(flag == false){
                flag = !flag;
            }else {
                throw new RuntimeException("单例模式被侵犯！");
            }
        }
    }

    private  static class SingletonHolder{
        private static final ElvisModified INSTANCE = new ElvisModified();
    }

    public static ElvisModified getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    public void doSomethingElse()
    {

    }
}
