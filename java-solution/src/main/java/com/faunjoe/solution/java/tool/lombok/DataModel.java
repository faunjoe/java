package com.faunjoe.solution.java.tool.lombok;

import lombok.Data;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-02 11:31
 */
@Data
public class DataModel {
    private String make;

    private String model;

    private String bodyType;

    private int yearOfManufacture;

    private int cubicCapacity;

    public static void main(String[] args){
        DataModel model = new DataModel();
        model.setBodyType("hello");
        model.setMake("world");
        model.setModel("china");
        model.setCubicCapacity(120);
        model.setYearOfManufacture(2019);
        System.out.println(model.toString());
    }
}
