package com.javase.oopFundamental.javabean;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/20:26
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Student s1=new Student();
        s1.setName("xx");
        s1.setScore(10);
        System.out.println(s1.getName());

        StudentOperate studentOperate = new StudentOperate(s1);
        studentOperate.printPass();


    }
}
