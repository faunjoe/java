package aop.demo6;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class GreetingBeforeAndAfterAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before");
    }

    @Override
    public void afterReturning(Object result, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("After");
    }
}
