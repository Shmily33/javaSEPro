package com.javase.oop1.singleinstance;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午2:56
 * @Description: 懒汉式单例
 */
public class B {

    private static B b;

    private B() {

    }

    public static B getInstance() {
        if (b == null) {
            System.out.println("first create instance");
            b = new B();
        }
        return b;
    }

}
