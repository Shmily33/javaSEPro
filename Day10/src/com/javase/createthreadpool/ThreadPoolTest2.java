package com.javase.createthreadpool;

import java.util.concurrent.*;

/**
 * @Author: gs_wang
 * @Date: 2024/06/20/下午8:09
 * @Description:
 */
public class ThreadPoolTest2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建一个线程池对象
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 8, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(4), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        //
        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(200));
        Future<String> f3 = pool.submit(new MyCallable(300));
        Future<String> f4 = pool.submit(new MyCallable(400));
        //
        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());


    }
}
