package com.faunjoe.app.config.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class EntityBeanDefinitionParse implements BeanDefinitionParser{

	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		String id = element.getAttribute("id");
		String beanClassName = element.getAttribute("class");
		BeanDefinition definition = new RootBeanDefinition();
		definition.setBeanClassName(beanClassName);
		BeanDefinitionReaderUtils.registerBeanDefinition(new BeanDefinitionHolder(definition, id), parserContext.getRegistry());
		return definition;
	}
}
