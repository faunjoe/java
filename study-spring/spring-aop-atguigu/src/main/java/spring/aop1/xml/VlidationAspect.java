package spring.aop1.xml;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/26 15:28
 */
public class VlidationAspect {
    public void validateArgs(JoinPoint joinPoint) {
        System.out.println("-->validate:" + Arrays.asList(joinPoint.getArgs()));
    }
}
