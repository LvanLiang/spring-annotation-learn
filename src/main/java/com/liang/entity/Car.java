package com.liang.entity;

import org.springframework.stereotype.Component;

/**
 * 用注解的方式，来测试bean的生命周期
 * @author Liangxp
 * @date 2019/6/22 13:47
 */
@Component
public class Car {
    private String name;
    private double price;

    public Car() {
        System.out.println("car……constructor……");
    }

    public Car(String name, double price) {
        System.out.println("car……agrs……constructor……");
        this.name = name;
        this.price = price;
    }

    public void init(){
        System.out.println("car……init……");
    }

    public void destory(){
        System.out.println("car……detory……");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
