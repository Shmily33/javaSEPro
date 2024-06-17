package com.javase.homework;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: gs_wang
 * @Date: 2024/06/17/下午7:18
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "小亮", 99));
        students.add(new Student(2, "小强", 88));
        students.add(new Student(3, "小美", 98));
        students.add(new Student(4, "小明", 45));
        students.add(new Student(5, "小明", 46));
        students.sort(((o1, o2) -> Double.compare(o2.getScore(), o1.getScore())));
        students.forEach(System.out::println);
        System.out.println("-------------------------------");
        Collections.sort(students, (o1, o2) -> Double.compare(o1.getScore(), o2.getScore()));
        students.forEach(System.out::println);
        System.out.println("-------------------------------");
        students.stream().sorted(((o1, o2) -> Double.compare(o2.getScore(), o1.getScore()))).forEach(System.out::println);
    }
}
