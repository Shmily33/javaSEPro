package com.javase.oop3.homework;

/**
 * @Author: gs_wang
 * @Date: 2024/06/15/上午10:57
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        // 在此处完成代码
        A a = new A();
        a.methodA(new C());
        a.methodA(new D());


    }
}
//定义接口
interface InterA {
    void showA();
}
class A {
    public void methodA(InterA a) {
        a.showA();
    }
}
class C implements InterA{
    public void showA() {
        System.out.println("我是没有名字的InterA的实现类");
    }
}
class D implements InterA{
    public void showA() {
        System.out.println("我是有名字的InterA的实现类");

    }
}