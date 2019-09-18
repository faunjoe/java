package com.faunjoe.solution.java.tool.lombok;

import lombok.*;

/**
 * 默认情况下， @EqualsAndHashCode会创建包含所有成员变量的 equals和 hashCode方法。
 * exclude选项可用于通知 Lombok排除某些成员变量。
 * 在上面的代码片段中。我已经从生成的 equals和 hashCode方法中排除了 yearOfManuFacture 和 cubicCapacity。
 * @author faunjoe
 * @version 创建时间：2019-06-02 11:24
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"yearOfManufacture","cubicCapacity"})
public class EqualsAndHashCodeModel {

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
}
