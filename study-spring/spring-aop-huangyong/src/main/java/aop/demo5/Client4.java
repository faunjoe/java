package aop.demo5;

import aop.demo4.Hello;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 5. Spring AOP：前置增强 + 后置增强（编程式）
 */
public class Client4 {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new Hello());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        proxyFactory.addAdvice(new GreetingAfterAdvice());

        Hello hello = (Hello) proxyFactory.getProxy();
        hello.say();
    }
}
