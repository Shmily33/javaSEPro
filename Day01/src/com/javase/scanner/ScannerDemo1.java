package com.javase.scanner;

import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/07/16:30
 * @Description:
 */
public class ScannerDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你的年龄：");
        int age = sc.nextInt();

        System.out.println("请输入你的姓名：");
        String name = sc.next();

        System.out.println("年龄：" + age + " 姓名：" + name);
    }

}
