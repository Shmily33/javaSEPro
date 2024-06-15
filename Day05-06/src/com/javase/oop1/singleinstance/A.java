package com.javase.oop1.singleinstance;

/**
 * @Author: gs_wang
 * @Date: 2024/06/13/下午7:11
 * @Description: 单例类 对外只有一个对象
 */
public class A {

    // 2、定义一个类变量记住类的一个对象
    private static A a = new A();

    // 1、私有构造器
    private A() {

    }
    //3、定义一个类方法，返回对象
    public static A getObject(){
        return a;
    }

}
