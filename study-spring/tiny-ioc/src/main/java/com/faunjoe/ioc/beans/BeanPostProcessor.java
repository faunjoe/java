package com.faunjoe.ioc.beans;

/**
 * bean post processer interface
 *
 * @author faunjoe
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
