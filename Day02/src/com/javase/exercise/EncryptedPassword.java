package com.javase.exercise;

import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/16:15
 * @Description:
 */
public class EncryptedPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println("加密前：" + number + " 加密后：" + encryptPassword(number));
    }

    public static String encryptPassword(int password) {
        String temp = Integer.toString(password);
        String res = "";
        for (int i = 0; i < temp.length(); i++) {
            int x = temp.charAt(i) - '0';
            res += (x + 5) % 10;

        }
        //翻转字符串 reverse完还是StringBuilder对象，要toString一下
        StringBuilder result = new StringBuilder(res).reverse();
        return result.toString();
    }
}
