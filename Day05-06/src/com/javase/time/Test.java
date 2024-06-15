package com.javase.time;

import java.time.LocalDate;

/**
 * @Author: gs_wang
 * @Date: 2024/06/15/下午3:09
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println(ld.getDayOfYear());
//        System.out.println((double) 2 / 3);
    }
}
