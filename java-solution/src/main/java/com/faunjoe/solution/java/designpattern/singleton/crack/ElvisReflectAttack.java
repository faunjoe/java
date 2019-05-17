package com.faunjoe.solution.java.designpattern.singleton.crack;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-03-01 18:00
 */
public class ElvisReflectAttack {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> classType = Elvis.class;

        Constructor<?> c = classType.getDeclaredConstructor(null);

        c.setAccessible(true);
        Elvis e1 = (Elvis) c.newInstance();
        Elvis e2 = (Elvis) c.newInstance();
        System.out.println(e1 == e2);
    }
}
