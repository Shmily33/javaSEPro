package com.javase.createthread;

/**
 * @Author: gs_wang
 * @Date: 2024/06/19/下午4:29
 * @Description:
 */
public class RunnableTest {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable(); // 任务对象
        Thread t1 = new Thread(r); // 线程对象
        t1.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程1" + i);
        }

        // 匿名内部类写法，得到任务对象
        Runnable target = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程输出" + i);
                }
            }
        };
        new Thread(target).start();
        // 简化写法1
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子线程2输出" + i);
                }
            }
        }).start();
        // 简化写法2
        new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                System.out.println("子线程3输出" + i);
            }

        }).start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程2" + i);
        }


    }
}
