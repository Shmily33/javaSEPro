package com.javase.oop2.abstract_;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午5:30
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        // 抽象类不能创建对象


        // 应用场景之一：设计模板设计方法模式
        Teacher teacher = new Teacher();
        teacher.write();
        Student student = new Student();
        student.write();
    }
}
