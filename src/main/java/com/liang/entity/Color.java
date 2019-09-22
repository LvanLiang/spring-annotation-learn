package com.liang.entity;

/**
 * @author Liangxp
 *
 * @date 2019/6/22 13:56
 */
public class Color {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}
