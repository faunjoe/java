package aop.demo4;

/**
 * Created by Administrator on 2014-07-02.
 */
public class HelloClient {
    public static void main(String[] args) {
        Hello hello = CGLibDynamicProxy.getInstance().getProxy(Hello.class);
        hello.say();
    }
}
