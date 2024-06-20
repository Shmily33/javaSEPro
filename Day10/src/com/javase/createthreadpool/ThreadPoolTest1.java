package com.javase.createthreadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: gs_wang
 * @Date: 2024/06/20/下午8:09
 * @Description:
 */
public class ThreadPoolTest1 {

    public static void main(String[] args) {
        // 创建一个线程池对象
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 8, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        //
        Runnable target = new MyRunnable();
        pool.execute(target); // 线程池自动创建，自动处理，自动执行
        pool.execute(target); // 线程池自动创建，自动处理，自动执行
        pool.execute(target); // 线程池自动创建，自动处理，自动执行
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        // 到临时线程了-任务队列最大是4
        pool.execute(target);
        pool.execute(target);
        // 到了新任务拒绝时机
        pool.execute(target);


    }
}
