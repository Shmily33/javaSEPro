package com.javase.lock;

/**
 * @Author: gs_wang
 * @Date: 2024/06/19/下午6:42
 * @Description:
 */
public class DrawThread extends Thread{
    private Account acc;
    public DrawThread(Account acc,String name) {
        super(name);
        this.acc = acc;
    }
    @Override
    public void run(){
        acc.drawMoney3(100000);
    }
}
