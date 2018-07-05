package com.springstudy.simplespring;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/30 01:48
 */
public class BeanDefinition {
    private Class beanClass;
    private String beanClassName;
    private PropertyValues propertyValues;

    public Class getBeanClass() {
        return beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        // 根据类名设置类
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues pvs) {
        this.propertyValues = pvs;
    }
}
