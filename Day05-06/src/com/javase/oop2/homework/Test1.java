package com.javase.oop2.homework;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午8:31
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
       Breeder breeder = new Breeder();
       breeder.breed(new Dog());
        breeder.breed(new Frog());
        breeder.breed(new Sheep());

    }
}
