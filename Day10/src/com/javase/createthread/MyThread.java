package com.javase.createthread;

/**
 * @Author: gs_wang
 * @Date: 2024/06/19/下午4:23
 * @Description:
 */
public class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("my thread is running." + i);
        }
    }
}
