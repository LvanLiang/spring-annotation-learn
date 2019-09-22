package com.liang.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Liangxp
 *
 * @date 2019/6/22 10:27
 */
public class Person {
    //使用@Value赋值；
    //1、基本数值
    //2、可以写SpEL； #{}
    //3、可以写${}；取出配置文件【properties】中的值（在运行环境变量里面的值）


    @Value("张三")
    private String name;

    @Value("#{30-2}")
    private int age;

    @Value("${person.nickname}")
    private String nikcName;

    public Person() {
        System.out.println("Person …… constructor……");
    }

    public Person(String name, int age) {
        System.out.println("Person …agrs… constructor……");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nikcName='" + nikcName + '\'' +
                '}';
    }
}
