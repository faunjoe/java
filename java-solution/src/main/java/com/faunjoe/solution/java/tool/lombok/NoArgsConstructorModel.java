package com.faunjoe.solution.java.tool.lombok;

import lombok.NoArgsConstructor;

/**
 * 将创建没有参数的构造函数
 * @author faunjoe
 * @version 创建时间：2019-06-02 11:20
 */
@NoArgsConstructor
public class NoArgsConstructorModel {
    private String make;

    private String model;

    private String bodyType;

    private int yearOfManufacture;

    private int cubicCapacity;
}
