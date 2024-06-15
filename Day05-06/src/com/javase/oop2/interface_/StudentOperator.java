package com.javase.oop2.interface_;

import com.sun.javaws.IconUtil;

import java.util.ArrayList;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午7:41
 * @Description:
 */
public interface StudentOperator {
    void printAllInfo(ArrayList<Student> students);
    void printAverageScore(ArrayList<Student> students);
//    static void test3(){
//        System.out.println("静态方法");
//    }
}
