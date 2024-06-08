package com.javase.oopFundamental.constructor;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/19:23
 * @Description:
 */
public class Student {
    //构造器，可重载
    public Student(){
        System.out.println("无参执行");
    }

    public Student(String name,double age){
        System.out.println("有参执行");

    }

}
