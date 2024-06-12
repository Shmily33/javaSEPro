package com.javase.string;

import java.util.Scanner;

import static java.lang.Character.*;

/**
 * @Author: gs_wang
 * @Date: 2024/06/12/16:46
 * @Description:
 */
public class SumStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sumStr(str);
    }

    public static void sumStr(String str) {
        int dig = 0;
        int up = 0;
        int low = 0;
        for (int i = 0; i < str.length(); i++) {
            if(isDigit(str.charAt(i))){
                dig++;
            }else if (isUpperCase(str.charAt(i))){
                up++;
            } else if (isLowerCase(str.charAt(i))) {
                low++;
            }
        }
        System.out.println("大写英文字母："+up+" 小写英文字母："+low+" 数字： "+dig);
    }

}
