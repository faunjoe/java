package com.faunjoe.beans;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 17:25
 */
public class YellowFactoryBean implements FactoryBean<Yellow> {

    //返回一个Yellow对象，这个对象会添加到容器中
    public Yellow getObject() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("YellowFactoryBean...getObject...");
        return new Yellow();
    }

    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return Yellow.class;
    }

    //是单例？
    //true：这个bean是单实例，在容器中保存一份
    //false：多实例，每次获取都会创建一个新的bean；
    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return true;
    }
}
