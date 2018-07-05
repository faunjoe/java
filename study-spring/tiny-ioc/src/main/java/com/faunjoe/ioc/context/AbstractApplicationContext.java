package com.faunjoe.ioc.context;

import com.faunjoe.ioc.beans.BeanDefinitionRegistry;
import com.faunjoe.ioc.factory.ConfigurableListableBeanFactory;
import com.faunjoe.ioc.factory.DefaultListableBeanFactory;

/**
 * AbstractApplicationContext
 * @author faunjoe
 */
public abstract class AbstractApplicationContext implements ApplicationContext{
	private ConfigurableListableBeanFactory beanFactory;
	
	@Override
    public Object getBean(String beanName) {
        return beanFactory.getBean(beanName);
    }
	
	public void refresh() throws Exception{
	    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		loadBeanDefinitions(beanFactory);
		this.beanFactory = beanFactory;
		onRefresh();
	}
	
	protected void onRefresh() throws Exception {
		beanFactory.preInstantiateSingletons();
	}

	protected abstract void loadBeanDefinitions(BeanDefinitionRegistry registry) throws Exception;
}
