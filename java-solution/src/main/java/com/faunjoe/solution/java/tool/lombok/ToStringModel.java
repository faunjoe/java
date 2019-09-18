package com.faunjoe.solution.java.tool.lombok;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 在你的数据类上覆盖 toString方法是有助于记录日志的良好实践
 * @author faunjoe
 * @version 创建时间：2019-06-02 11:21
 */
@ToString
@NoArgsConstructor
public class ToStringModel {
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
        ToStringModel model = new ToStringModel();
        System.out.println(model.toString());
    }
}
