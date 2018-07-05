package aop.demo2;

import aop.Greeting;

public class GreetingProxy implements Greeting {

    private Greeting greeting;

    public GreetingProxy(Greeting greeting) {
        this.greeting = greeting;
    }

    @Override
    public void sayHello(String name) {
        before();
        greeting.sayHello(name);
        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
