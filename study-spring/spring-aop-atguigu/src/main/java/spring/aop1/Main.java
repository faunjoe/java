package spring.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/26 15:22
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");

        System.out.println(arithmeticCalculator.getClass().getName());

        int result = arithmeticCalculator.add(1, 2);
        System.out.println("result:" + result);

        result = arithmeticCalculator.div(1000, 10);
        System.out.println("result:" + result);
    }
}
