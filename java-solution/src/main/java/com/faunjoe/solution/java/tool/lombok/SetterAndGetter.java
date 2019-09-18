package com.faunjoe.solution.java.tool.lombok;

import lombok.Getter;
import lombok.Setter;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-02 11:13
 */
public class SetterAndGetter {
    @Getter
    @Setter
    private String make;

    @Getter
    @Setter
    private String model;

    @Getter
    @Setter
    private String bodyType;

    @Getter
    @Setter
    private int yearOfManufacture;

    @Getter
    @Setter
    private int cubicCapacity;

    public static void main(String[] args){
        SetterAndGetter model = new SetterAndGetter();
        model.setBodyType("aa");
        model.getBodyType();
    }
}
