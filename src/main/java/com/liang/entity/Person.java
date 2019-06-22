package com.liang.entity;

/**
 * @author: Liangxp
 * @Description:
 * @date: 2019/6/22 10:27
 */
public class Person {
    private String name;
    private int age;

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
                ", age='" + age + '\'' +
                '}';
    }
}
