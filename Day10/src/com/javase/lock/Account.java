package com.javase.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: gs_wang
 * @Date: 2024/06/19/下午6:39
 * @Description:
 */
public class Account {
    private String cardId;
    private double money;
    private final Lock lock = new ReentrantLock(); // 创建锁对象 final 唯一

    public String getCardId() {
        return cardId;
    }

    public void drawMoney(double money) {
        String name = Thread.currentThread().getName();
        synchronized (this) { // 同一个对象
            if (this.money >= money) {
                System.out.println(name + "来取钱:" + money);
                this.money -= money;
                System.out.println(name + "取钱后剩余：" + this.money);
            } else {
                System.out.println(name + "来取钱，" + money + "但是余额不足");
            }
        }
    }

    public synchronized void drawMoney1(double money) { // 同步方法
        String name = Thread.currentThread().getName();

        if (this.money >= money) {
            System.out.println(name + "来取钱:" + money);
            this.money -= money;
            System.out.println(name + "取钱后剩余：" + this.money);
        } else {
            System.out.println(name + "来取钱，" + money + "但是余额不足");
        }

    }

    public  void drawMoney3(double money) { // lock
        String name = Thread.currentThread().getName();
        lock.lock(); // 加锁
        try {
            if (this.money >= money) {
                System.out.println(name + "来取钱:" + money);
                this.money -= money;
                System.out.println(name + "取钱后剩余：" + this.money);
            } else {
                System.out.println(name + "来取钱，" + money + "但是余额不足");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock(); // 防止中间代码有bug 解不了锁，放在finally 肯定能解锁释放资源
        }


    }


    public static void test(double money) {
        synchronized (Account.class) { // 静态方法 用类名.class--因为静态方法是通过类名.方法调用的
            String name = Thread.currentThread().getName();
            System.out.println(name + "来取钱:" + money);
        }
    }

    public Account() {
    }

    public Account(String cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
