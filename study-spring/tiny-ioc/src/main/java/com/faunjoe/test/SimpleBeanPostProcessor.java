package com.faunjoe.test;

import com.faunjoe.ioc.beans.BeanPostProcessor;

/**
 * SimpleBeanPostProcessor
 *
 * @author faunjoe
 */
public class SimpleBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        System.out.println(beanName + " initialize before.");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        System.out.println(beanName + " initialize after.");
        return null;
    }

}
