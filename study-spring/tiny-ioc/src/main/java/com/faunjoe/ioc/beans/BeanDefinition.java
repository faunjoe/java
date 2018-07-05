package com.faunjoe.ioc.beans;

/**
 * 定义bean的数据结构
 *
 * @author faunjoe
 */
public class BeanDefinition {

    /**
     * bean名称
     */
    private String beanName;

    /**
     * bean的class对象
     */
    private Class beanClass;

    /**
     * bean的class的包路径
     */
    private String beanClassName;

    /**
     * bean依赖属性
     */
    private PropertyValues propertyValues = new PropertyValues();

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

}
