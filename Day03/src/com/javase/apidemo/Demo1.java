package com.javase.apidemo;

import com.javase.apitest.Demo;

import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/12/10:10
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        //idea 自动快速导包测试
        Demo demo = new Demo();
        demo.print();
        Scanner sc = new Scanner(System.in);
        String s = "hgeh";
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
//            s.equalsIgnoreCase()
        }
    }
}
