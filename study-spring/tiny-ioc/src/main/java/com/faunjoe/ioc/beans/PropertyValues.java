package com.faunjoe.ioc.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 用来存储依赖属性
 *
 * @author faunjoe
 */
public class PropertyValues {

    private List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValues.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValues;
    }
}
