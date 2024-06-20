package com.javase.createthreadpool;

/**
 * @Author: gs_wang
 * @Date: 2024/06/20/下午8:16
 * @Description:
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "输出666");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
