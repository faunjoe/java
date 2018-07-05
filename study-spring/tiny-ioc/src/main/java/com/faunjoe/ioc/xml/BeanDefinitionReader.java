package com.faunjoe.ioc.xml;

/**
 * 定义BeanDefinition读取接口
 * @author faunjoe
 */
public interface BeanDefinitionReader {

	/**
	 * BeanDefinition读取接口
	 * @param location
	 * @throws Exception
	 */
	void loadBeanDefinitions(String location) throws Exception;
}
