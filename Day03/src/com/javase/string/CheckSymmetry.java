package com.javase.string;

import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/12/15:31
 * @Description: 判断字符串是否对称
 */
public class CheckSymmetry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(checkSymmetry(str));
    }

    public static boolean checkSymmetry(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        String reverse = stringBuilder.reverse().toString();
        return str.equals(reverse);
    }

}
