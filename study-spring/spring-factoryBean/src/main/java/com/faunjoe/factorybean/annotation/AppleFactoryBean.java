package com.faunjoe.factorybean.annotation;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/16 15:49
 */

@Component
public class AppleFactoryBean implements FactoryBean<AppleBean> {
    public AppleBean getObject() throws Exception {
        return new AppleBean();
    }

    public Class<?> getObjectType() {
        return AppleBean.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
