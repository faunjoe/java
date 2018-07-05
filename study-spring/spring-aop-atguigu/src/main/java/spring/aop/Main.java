package spring.aop;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/26 14:38
 */
public class Main {

    public static void main(String[] args){

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();

        System.out.println(arithmeticCalculator.add(10,20));

//        arithmeticCalculator = new ArithmeticCalculatorLoggingImpl();
//        System.out.println(arithmeticCalculator.add(10,20));

        arithmeticCalculator = new ArithmeticCalculatorLoggingProxy(arithmeticCalculator).getLoggingProxy();

        System.out.println(arithmeticCalculator.add(10,20));
        System.out.println(arithmeticCalculator.getClass().getName());
    }
}
