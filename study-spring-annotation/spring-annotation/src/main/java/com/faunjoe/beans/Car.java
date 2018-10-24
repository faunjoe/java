package com.faunjoe.beans;

/**
 * @author faunjoe E-mail:aijun.fu@mtime.com
 * @version 创建时间：2018/7/22 14:06
 */
public class Car {

    private String name;
    private String brand;
    private Integer price;

    public Car() {
        System.out.println("Constructor Car()");
    }

    public Car(String name, String brand, Integer price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        System.out.println("Car(String name, String brand, Integer price)");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void init(){
        System.out.println("car ... init...");
    }

    public void detory(){
        System.out.println("car ... detory...");
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
