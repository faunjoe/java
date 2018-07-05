package aop.demo3;

import aop.Hello;

/**
 * Created by Administrator on 2014-07-02.
 */
public class HelloClient {
    public static void main(String[] args) {
        Hello hello = new JDKDynamicProxy(new HelloImpl()).getProxy();
        hello.smile();
        hello.cry();
    }
}
