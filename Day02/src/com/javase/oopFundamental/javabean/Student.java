package com.javase.oopFundamental.javabean;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/20:26
 * @Description: Student实体类
 */
public class Student {
    //1、必须私有变量,并提高get、set方法
    private String name;
    private double score;

    //2、必须为类提供一个无参构造器

    public Student() {
    }

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
