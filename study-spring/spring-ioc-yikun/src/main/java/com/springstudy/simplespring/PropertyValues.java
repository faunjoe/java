package com.springstudy.simplespring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/6/30 01:49
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList;

    public PropertyValues() {
        this.propertyValueList = new ArrayList<PropertyValue>();
    }

    public void addPropertyValue(PropertyValue pv) {
        propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
