package com.javase.juint;

/**
 * @Author: gs_wang
 * @Date: 2024/06/20/下午8:48
 * @Description:
 */
public class StringUtils {
    public static void printNumber(String name) {
        System.out.println("名字长度" + name.length());
    }

    public static int getMaxIndex(String num) {
        if (num == null) return -1;
        return num.length();
    }
}
