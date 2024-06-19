package com.javase.createthread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: gs_wang
 * @Date: 2024/06/19/下午4:41
 * @Description:
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable call = new MyCallable(100);

        // 封装为FutureTask对象(任务对象)
        // 是一个任务对象，实现了Runnable对象
        // 在线程执行完成后，用在未来任务对象调用get方法获取线程执行完毕后的结果
        FutureTask<String> f1 = new FutureTask<>(call);
        new Thread(f1).start();  // 交给线程对象


        MyCallable call2 = new MyCallable(200);
        FutureTask<String> f2 = new FutureTask<>(call2);
        new Thread(f2).start();

        //获取线程执行完毕的结果
        // 如果执行到这上面的线程还没有执行完毕，这里的代码会暂停，等待上面线程执行完毕获得结果
        String s = f1.get();
        String s1 = f2.get();
        System.out.println(s);
        System.out.println(s1);


    }
}
