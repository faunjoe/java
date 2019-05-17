package com.faunjoe.solution.java.designpattern.readwritelock;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-31 10:51
 */
public class ReadWritLockClient {

    public static void main(String[] args){
        final SharedData sharedData = new SharedData(10);
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new WriterWorker(sharedData,"faunjoe-faunjoe").start();
        new WriterWorker(sharedData,"FAUNJOE-FAUNJOE").start();
    }
}
