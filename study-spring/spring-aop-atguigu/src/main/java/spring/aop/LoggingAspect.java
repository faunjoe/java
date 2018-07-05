package spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/26 14:32
 */

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public int spring.aop.ArithmeticCalculator.*(int,int))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        System.out.println(" The method " + methodName + " begin with " + Arrays.asList(args));
    }

    @After("execution(* spring.aop.ArithmeticCalculator.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();

        System.out.println(" The method " + methodName + " ends");
    }
}
