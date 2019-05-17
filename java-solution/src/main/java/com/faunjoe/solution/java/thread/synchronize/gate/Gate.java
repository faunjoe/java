package com.faunjoe.solution.java.thread.synchronize.gate;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-31 00:04
 */
public class Gate {

    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;

        verify();

    }

    private void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("************Broken**************" + toString());
        }
    }

    @Override
    public String toString() {
        return "No." + counter + ":" + name + ":" + address;
    }


}
