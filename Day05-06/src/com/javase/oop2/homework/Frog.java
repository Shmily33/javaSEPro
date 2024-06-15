package com.javase.oop2.homework;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午8:39
 * @Description:
 */
public class Frog extends Animal implements Swim{
    @Override
    public void swim() {
        System.out.println("青蛙蛙泳");
    }

    @Override
    public void eat() {
        System.out.println("青蛙吃虫");
    }
}
