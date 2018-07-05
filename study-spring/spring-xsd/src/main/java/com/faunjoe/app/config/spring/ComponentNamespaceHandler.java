package com.faunjoe.app.config.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class ComponentNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("component", new ComponentBeanDefinitionParser());
    }
}