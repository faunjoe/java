package spring.aop1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/26 15:20
 */

// order 越小优先级越高
@Order(1)
@Aspect
@Component
public class VlidationAspect {

    @Before("spring.aop1.LoggingAspect.declareJointPointExpression()")
    public void validateArgs(JoinPoint joinPoint) {
        System.out.println("-->validate:" + Arrays.asList(joinPoint.getArgs()));
    }
}
