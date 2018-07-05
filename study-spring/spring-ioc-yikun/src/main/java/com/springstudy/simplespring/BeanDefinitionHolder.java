package com.springstudy.simplespring;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/30 01:48
 */
public class BeanDefinitionHolder {
    private final BeanDefinition beanDefinition;
    private final String beanName;

    public BeanDefinitionHolder(String beanName, BeanDefinition beanDefinition) {
        this.beanName = beanName;
        this.beanDefinition = beanDefinition;
    }

    public BeanDefinition getBeanDefinition() {
        return this.beanDefinition;
    }

    public String getBeanName() {
        return this.beanName;
    }
}