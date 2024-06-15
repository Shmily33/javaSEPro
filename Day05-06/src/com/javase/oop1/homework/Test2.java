package com.javase.oop1.homework;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午4:28
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        Dog dog = new Dog("旺财","蓝色",100);
        Cat cat = new Cat("波斯猫", "黑色", 200);
        dog.eat();
        dog.lookHome();
        System.out.println("---------------");
        cat.eat();
        cat.catchMouse();
    }
}


class Animal{
    private String name;
    private String color;
    private double price;

    public Animal() {
    }

    public Animal(String name, String color, double price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void eat(){
        System.out.println(name+"在吃饭");
    }

}
class Dog extends Animal{
    public Dog() {
    }

    public Dog(String name, String color, double price) {
        super(name, color, price);
    }

    public void eat(){
        super.eat();
    }

    public void lookHome(){
        System.out.println(getName()+"看家");
    }

}
class Cat extends Animal{
    public Cat() {
    }

    public Cat(String name, String color, double price) {
        super(name, color, price);
    }
    public void eat(){
        super.eat();
    }
    public void catchMouse(){
        System.out.println(getName()+"抓老鼠");
    }
}