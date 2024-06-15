package com.javase.oop2.homework;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午8:31
 * @Description:
 */
public class Animal {
    private int age;

    public void drink() {
        System.out.println("喝水");
    }

    public Animal(int age) {
        this.age = age;
    }

    public Animal() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println("吃东西");
    }
}
