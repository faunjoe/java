package com.faunjoe.app.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
//@Order(1)
public class AspectJAnnotationBrowserAroundAdvice implements Ordered {

    @Pointcut("execution(* com.faunjoe.app.entity.ChromeBrowser.*(..))")
    private void pointcut() {

    }

    //@Around(value="pointcut()")
    @Around("execution(* com.faunjoe.app.entity.ChromeBrowser.*(..))")
    public Object aroundIntercept(ProceedingJoinPoint pjp) throws Throwable {
        //encrypt();
        System.out.println("around before 2");
        Object retVal = pjp.proceed();
        System.out.println("around after 2");
        //decrypt();
        return retVal;
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+ methodName + "begin with args "+args.toString());
        System.out.println("before 2");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method "+ methodName + "begin with args "+args.toString());
        System.out.println("after 2");
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("after returning 2");
    }

    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowing(Exception ex) throws Exception {
        System.out.println("afterThrowing 2");
        throw ex;
    }

    // 加密
    private void encrypt() {
        System.out.println("encrypt 2 ...");
    }

    // 解密
    private void decrypt() {
        System.out.println("decrypt 2 ...");
    }

    @Override
    public int getOrder() {
        // TODO Auto-generated method stub
        return 2;
    }
}
