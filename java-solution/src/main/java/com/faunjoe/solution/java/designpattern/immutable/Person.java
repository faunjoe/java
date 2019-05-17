package com.faunjoe.solution.java.designpattern.immutable;

/**
 * 不可变对象。
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018-12-31 22:47
 */
public final class Person {

    private final String name;
    private final String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
