package com.faunjoe.ioc.factory;

/**
 * ConfigurableListableBeanFactory
 * @author faunjoe
 */
public interface ConfigurableListableBeanFactory extends BeanFactory{

    /**
     * preInstantiateSingletons
     * @throws Exception
     */
    void preInstantiateSingletons() throws Exception;
}
