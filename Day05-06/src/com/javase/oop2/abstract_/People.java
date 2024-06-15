package com.javase.oop2.abstract_;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午7:12
 * @Description:
 */
public abstract class People {
    /**
     * 设计模板方法设计模式
     * 1、定义一个模板方法
     * 2、并不清楚后续实现，但是知道子类必须要写
     */
    public final void write() { //模板方法，final禁止子类重写
        System.out.println("\t\t\t\t1111");
        System.out.println("\t\t\t2222");
        System.out.println("\t\t3333");
        System.out.println(writeMain());
        System.out.println("结束");
    }

    // 3、设计一个抽象方法，具体实现交给子类
    public abstract String writeMain();

}
