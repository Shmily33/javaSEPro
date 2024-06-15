package com.javase.oop3.homework;

/**
 * @Author: gs_wang
 * @Date: 2024/06/15/上午10:45
 * @Description:
 */
interface Inter {
    void show();
}
class Outer {

    //补齐代码，要求在控制台输出”HelloWorld”
    public static Inter method(){
        return new B();
    }
}

class B implements Inter{
    public void show(){
        System.out.println("HelloWorld");
    }
}
public class OuterDemo {
    public static void main(String[] args) {
        Outer.method().show();
    }
}