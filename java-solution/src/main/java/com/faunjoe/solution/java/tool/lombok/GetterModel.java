package com.faunjoe.solution.java.tool.lombok;

import lombok.Getter;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-02 11:15
 */
public class GetterModel {
    @Getter
    private String make;

    @Getter
    private String model;

    @Getter
    private String bodyType;

    @Getter
    private int yearOfManufacture;

    @Getter
    private int cubicCapacity;

    public static void main(String[] args){
        GetterModel model = new GetterModel();
        model.getBodyType();
    }
}


