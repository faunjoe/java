package com.faunjoe.ioc.beans;

/**
 * 通过键值对记录依赖属性的名称和值或引用
 *
 * @author faunjoe
 */
public class PropertyValue {

    /**
     * 属性名称
     */
    private final String name;

    /**
     * 属性值或引用
     */
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
