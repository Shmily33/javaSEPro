package com.javase.oop2.interface_;

import java.util.ArrayList;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午7:43
 * @Description:
 */
public class StudentOperatorImpl1 implements StudentOperator {
    @Override
    public void printAllInfo(ArrayList<Student> students) {
        System.out.println("--------全部信息-------");
        for (Student student : students) {
            System.out.println("姓名：" + student.getName() + " 性别：" + student.getSex() + " 分数：" + student.getScore());
        }
    }

    @Override
    public void printAverageScore(ArrayList<Student> students) {
        System.out.println("--------平均分--------");
        double sum = 0;
        for (Student student : students) {
            sum += student.getScore();
        }
        System.out.println("平均分为：" + sum / students.size());
    }
}
