package com.javase.lock;

/**
 * @Author: gs_wang
 * @Date: 2024/06/19/下午6:37
 * @Description:
 */
public class SynchronizedThreadTest {
    public static void main(String[] args) {
        Account acc = new Account("ICBC-110", 100000);
        new DrawThread(acc, "小明").start();
        new DrawThread(acc, "小红").start();

        Account acc1 = new Account("ICBC-111", 100000);
        new DrawThread(acc1, "小黑").start();
        new DrawThread(acc1, "小白").start();

    }
}
