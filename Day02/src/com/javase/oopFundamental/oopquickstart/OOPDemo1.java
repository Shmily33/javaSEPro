package com.javase.oopFundamental.oopquickstart;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/18:38
 * @Description: 面向对象编程基础
 */
public class OOPDemo1 {
    //面向学生编程
    public static void main(String[] args) {
        //1、创建学生对象
        Student s1 = new Student();
        //2、封装数据
        s1.name = "张三";
        s1.chinese = 100;
        s1.math = 80;
        s1.printAvgScore();
    }

}
