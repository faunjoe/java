package com.faunjoe.solution.java.designpattern.singleton.crack;

import java.lang.reflect.Constructor;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2019-03-01 18:00
 */
public class ElvisModifiedReflectAttack {

    public static void main(String[] args) {
        try {
            Class<ElvisModified> classType = ElvisModified.class;

            Constructor<ElvisModified> c = classType.getDeclaredConstructor(null);
            c.setAccessible(true);
            ElvisModified e1 = (ElvisModified) c.newInstance();
            ElvisModified e2 = ElvisModified.getInstance();
            System.out.println(e1 == e2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
