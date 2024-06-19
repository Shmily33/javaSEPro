package com.javase.createthread;

import java.util.concurrent.Callable;

/**
 * @Author: gs_wang
 * @Date: 2024/06/19/下午4:41
 * @Description:
 */
public class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        // 描述线程的任务，返回线程执行返回后的结果
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return "线程1求出的1-" + n + "和为：" + sum;
    }
}
