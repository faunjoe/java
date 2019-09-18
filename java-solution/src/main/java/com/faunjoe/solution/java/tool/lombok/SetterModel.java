package com.faunjoe.solution.java.tool.lombok;

import lombok.Setter;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-02 11:14
 */
public class SetterModel {
    @Setter
    private String make;

    @Setter
    private String model;

    @Setter
    private String bodyType;

    @Setter
    private int yearOfManufacture;

    @Setter
    private int cubicCapacity;

    public static void main(String[] args){
        SetterModel model = new SetterModel();
        model.setBodyType("");
    }
}
