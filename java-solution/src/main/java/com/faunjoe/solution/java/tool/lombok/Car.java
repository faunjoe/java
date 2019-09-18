package com.faunjoe.solution.java.tool.lombok;


import java.util.Objects;

/**
 * @author faunjoe
 * @version 创建时间：2019-06-02 11:09
 */
public class Car {

    private String make;

    private String model;

    private String bodyType;

    private int yearOfManufacture;

    private int cubicCapacity;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(int cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return make.equals(car.make) &&
                model.equals(car.model) &&
                bodyType.equals(car.bodyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, bodyType);
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", cubicCapacity=" + cubicCapacity +
                '}';
    }
}
