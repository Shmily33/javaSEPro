package com.javase.oop2.interface_;

import java.util.ArrayList;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午7:47
 * @Description:
 */
public class StudentOperatorImpl2 implements StudentOperator {
    @Override
    public void printAllInfo(ArrayList<Student> students) {
        System.out.println("--------全部信息-------");
        int boy = 0;
        int girl = 0;
        for (Student student : students) {
            if (student.getSex() == '男') {
                boy++;
            } else if (student.getSex() == '女') {
                girl++;
            }
            System.out.println("姓名：" + student.getName() + " 性别：" + student.getSex() + " 分数：" + student.getScore());
        }
        System.out.println("男生人数是：" + boy + " 女生人数：" + girl);
    }

    @Override
    public void printAverageScore(ArrayList<Student> students) {
        System.out.println("--------平均分--------");
        double sum = 0;
        double max = students.get(0).getScore();
        double min = students.get(0).getScore();
        for (Student student : students) {
            sum += student.getScore();
            if (student.getScore() > max) {
                max = student.getScore();
            }
            if (student.getScore() < min) {
                min = student.getScore();
            }
        }
        System.out.println("平均分为：" + (sum - max - min) / (students.size() - 2));
    }
}
