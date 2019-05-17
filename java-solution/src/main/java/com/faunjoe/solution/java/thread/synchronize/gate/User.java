package com.faunjoe.solution.java.thread.synchronize.gate;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-31 00:09
 */
public class User extends Thread {

    private final String myName;

    private final String myAddress;

    private final Gate gate;

    public User(String myName, String myAddress, Gate gate) {
        this.myName = myName;
        this.myAddress = myAddress;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(myName + " begin ");
        while (true) {
            this.gate.pass(myName, myAddress);
        }
    }
}
