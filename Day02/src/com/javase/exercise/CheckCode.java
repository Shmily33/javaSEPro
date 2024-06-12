package com.javase.exercise;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/15:37
 * @Description:
 */
public class CheckCode {

    public static void main(String[] args) {
        System.out.println("请输入需要几位验证码：");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
//        System.out.println("验证码为：" + checkCode(num));
        System.out.println("验证码为：" + checkCode2(num));
    }

    public static String checkCode(int num) {
        String res = "";
        //Random使用前要先创建Random对象
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            int x = random.nextInt(3);//随机数：0 1 2
            switch (x) {
                case 0:
                    res +=  random.nextInt(10);
                    break;
                case 1:
                    res += (char) ('a' + random.nextInt(26));
                    break;
                case 2:
                    res += (char) ('A' + random.nextInt(26));
                    break;
            }
        }
        return res;
    }
    public static String checkCode2(int num) {
        String code = "";
        String data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int len = data.length();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            code += data.charAt(random.nextInt(len));
        }
        return code;
    }

}
