package com.faunjoe.ioc.factory;

/**
 * BeanFactory是一个顶级接口
 * @author faunjoe
 */
public interface BeanFactory {

	/**
	 * bean对象
	 * @param beanName
	 * @return
	 */
	Object getBean(String beanName);
}