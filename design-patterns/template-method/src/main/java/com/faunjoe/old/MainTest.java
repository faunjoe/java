package com.faunjoe.old;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/26 11:19
 */
public class MainTest {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        // 很明显，已经发现代码有点问题了，两个悍马的run方法完全相同。
        // 所以这个run方法应该出现在抽象类中，不应该在实现类中，抽象是所有子类的共性封装。
        HummerModel hummerModel = HummerH1.class.newInstance();
        hummerModel.run();
        System.out.println("- - - - - - - - - - - - - - - - - - ");
        hummerModel = HummerH2.class.newInstance();
        hummerModel.run();
    }
}
