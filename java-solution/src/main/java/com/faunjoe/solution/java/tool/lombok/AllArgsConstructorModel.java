package com.faunjoe.solution.java.tool.lombok;

import lombok.AllArgsConstructor;

/**
 * 数据类通常包含一个构造函数，它为每个成员变量接受参数。
 * @author faunjoe
 * @version 创建时间：2019-06-02 11:15
 */
@AllArgsConstructor
public class AllArgsConstructorModel {
    private String make;

    private String model;

    private String bodyType;

    private int yearOfManufacture;

    private int cubicCapacity;
}


