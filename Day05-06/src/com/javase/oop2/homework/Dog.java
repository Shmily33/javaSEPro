package com.javase.oop2.homework;

import com.javase.oop2.abstract_.A;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午8:36
 * @Description:
 */
public class Dog extends Animal implements Swim{
    @Override
    public void swim() {
        System.out.println("狗会狗刨");
    }

    public void eat() {
        System.out.println("狗啃骨头");
    }


}