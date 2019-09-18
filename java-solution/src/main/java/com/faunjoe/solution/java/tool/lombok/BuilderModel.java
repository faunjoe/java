package com.faunjoe.solution.java.tool.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-02 11:37
 */
@Builder
public class BuilderModel {
    private String make;

    private String model;

    private String bodyType;

    private int yearOfManufacture;

    private int cubicCapacity;

    @Singular("serviceDate")
    private List<LocalDate> serviceDate;

    public static void main(String[] args) {
        BuilderModel model1 = BuilderModel.builder()
                .make("Ford")
                .model("mustang")
                .serviceDate(Arrays.asList(LocalDate.of(2019, 6, 2)))
                .build();
        System.out.println(model1.toString());

        BuilderModel model2 = BuilderModel.builder()
                .make("Ford")
                .model("mustang")
                .serviceDate(LocalDate.of(2019, 6, 2))
                .build();
        System.out.println(model2.toString());
    }
}
