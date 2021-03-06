package com.kaikeba.util;

import com.kaikeba.beans.Dept;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/19 11:22
 */
public class MyObjectFactory extends DefaultObjectFactory {

    @Override
    public Object create(Class type) {

        // 重新定义Dept类实例对象创建规则，其他类实例对象创建规则不想改变
        if(Dept.class == type){
            //依靠父类提供create方法创建Dept实例对象
            Dept dept=(Dept) super.create(type);
            //设置自定义规则
            dept.setCountry("China");
            return dept;
        }
        return super.create(type);
    }
}
