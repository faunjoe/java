package com.faunjoe.ioc.context;

import com.faunjoe.ioc.beans.BeanDefinitionRegistry;
import com.faunjoe.ioc.resource.ResourceLoader;
import com.faunjoe.ioc.xml.XmlBeanDefinitionReader;

/**
 * ClasspathXmlApplicationContext
 * @author faunjoe
 */
public class ClasspathXmlApplicationContext extends AbstractApplicationContext {
	private String location;
	
	public ClasspathXmlApplicationContext(String location) {
		this.location = location;
		try {
			refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void loadBeanDefinitions(BeanDefinitionRegistry registry) throws Exception {
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry, new ResourceLoader());
		reader.loadBeanDefinitions(location);
	}

}
