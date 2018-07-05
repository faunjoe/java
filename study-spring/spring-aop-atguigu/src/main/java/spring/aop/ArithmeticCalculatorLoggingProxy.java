package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/26 14:13
 */
public class ArithmeticCalculatorLoggingProxy {

    //要代理的对象
    private ArithmeticCalculator target;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    // 返回代理对象
    public ArithmeticCalculator getLoggingProxy() {
        ArithmeticCalculator proxy = null;

        ClassLoader loader = target.getClass().getClassLoader();
        //Class[] interfaces = new Class[]{ArithmeticCalculator.class};
        Class[] interfaces = target.getClass().getInterfaces();

        InvocationHandler h = new InvocationHandler() {
            /**
             *
             * @param proxy 代理对象。一般不使用该对象
             * @param method 正在被调用的方法
             * @param args 调用方法传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                String methodName = method.getName();
                // 打印日志
                System.out.println("The method " + methodName + " begin with " + Arrays.asList(args));

                // 调用目标方法
                Object result = null;

                try {
                    // 前置通知
                    // 打印日志
                    System.out.println("[before] The method " + methodName + " begin with " + Arrays.asList(args));
                    result = method.invoke(target, args);
                    // 打印日志
                    // 返回通知，可以访问到方法的返回值。
                    System.out.println("[AfterReturning] The method " + methodName + " begin with " + Arrays.asList(args));
                } catch (Exception e) {
                    // 异常通知，可以访问到方法出现的异常
                    // 打印日志
                    System.out.println("[AfterThrowing] The method " + methodName + " begin with " + Arrays.asList(args));
                    e.printStackTrace();
                }

                // 后置通知，因为方法可能会出现异常，所以访问不到方法的返回值。
                //打印日志
                System.out.println("[after] The method ends with " + result);
                return result;
            }
        };

        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader,interfaces,h);
        return proxy;
    }

}
