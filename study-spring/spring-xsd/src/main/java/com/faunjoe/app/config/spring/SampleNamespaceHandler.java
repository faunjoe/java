package com.faunjoe.app.config.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class SampleNamespaceHandler extends NamespaceHandlerSupport{

	@Override
	public void init() {
		registerBeanDefinitionParser("entity", new EntityBeanDefinitionParse());
	}

}
