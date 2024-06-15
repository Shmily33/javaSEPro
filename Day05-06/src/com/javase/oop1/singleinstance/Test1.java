package com.javase.oop1.singleinstance;

/**
 * @Author: gs_wang
 * @Date: 2024/06/13/下午7:10
 * @Description: 单例设计模式的写法
 */
public class Test1 {
    public static void main(String[] args) {
        A a1 = A.getObject();
        A a2 = A.getObject();
        System.out.println(a1);
        System.out.println(a2);

        B b1 = B.getInstance();
        B b2 = B.getInstance();
        System.out.println(b1);
        System.out.println(b2);
    }
}
