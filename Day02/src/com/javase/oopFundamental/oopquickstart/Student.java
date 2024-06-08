package com.javase.oopFundamental.oopquickstart;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/18:38
 * @Description:
 */
public class Student {
    String name;
    double chinese;
    double math;

    public void printAvgScore() {
        System.out.println("学生：" + name + " 平均成绩为：" + (chinese + math) / 2);
    }
}
