package com.javase.oop2.interface_;

import java.util.ArrayList;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午7:38
 * @Description:
 */
public class ClassManger {
    private ArrayList<Student> students = new ArrayList<>();
    private StudentOperator studentOperator = new StudentOperatorImpl2();


    public ClassManger() {
        students.add(new Student("wgs1",'男',100));
        students.add(new Student("wgs2",'女',50));
        students.add(new Student("wgs3",'男',80));
        students.add(new Student("wgs4",'女',90));
    }

    public void printInfo(){
        studentOperator.printAllInfo(students);
    }

    public void printScore(){
        studentOperator.printAverageScore(students);
    }


}
