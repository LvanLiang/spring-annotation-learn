package com.liang.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * 用来测试@Autowired从构造器自动装配和从方法参数自动装配
 * 默认加在ioc容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值等操作
 * @author Liangxp
 * @date 2019/6/23 15:12
 */
@Component
public class Boss {
    private Car car;

    /**
     * 构造器要用的组件，都是从容器中获取
     */
    public Boss(@Autowired Car car) {
        System.out.println("boss有参构造函数......");
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    //@Autowired
    //标注在方法，Spring容器创建当前对象，就会调用方法，完成赋值；
    //方法使用的参数，自定义类型的值从ioc容器中获取
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
