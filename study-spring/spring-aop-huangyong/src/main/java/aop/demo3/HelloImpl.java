package aop.demo3;

import aop.Hello;

/**
 * Created by Administrator on 2014-07-02.
 */
public class HelloImpl implements Hello {
    @Override
    public void smile() {
        System.out.println("I'm smile");
    }

    @Override
    public void cry() {
        System.out.println("I'm cry");
    }
}
