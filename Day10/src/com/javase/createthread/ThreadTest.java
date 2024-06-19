package com.javase.createthread;

/**
 * @Author: gs_wang
 * @Date: 2024/06/19/下午4:23
 * @Description:
 */
public class ThreadTest {
    // main是主线程
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start(); // t线程
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出" + i);

        }
    }
}
