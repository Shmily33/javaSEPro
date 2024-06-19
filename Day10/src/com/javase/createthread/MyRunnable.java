package com.javase.createthread;

/**
 * @Author: gs_wang
 * @Date: 2024/06/19/下午4:29
 * @Description:
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello World" + i);
        }
    }
}
