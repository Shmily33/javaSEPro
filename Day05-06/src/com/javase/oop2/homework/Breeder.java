package com.javase.oop2.homework;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午8:50
 * @Description:
 */
public class Breeder {
    public void breed(Animal animal) {
//        if (animal instanceof Dog) {
//
//        }
        animal.drink();
        animal.eat();
        if (animal instanceof Dog || animal instanceof Frog) {
            ((Swim) animal).swim();
        }
    }




}
