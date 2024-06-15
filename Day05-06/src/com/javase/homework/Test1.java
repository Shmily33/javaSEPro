package com.javase.homework;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: gs_wang
 * @Date: 2024/06/15/下午5:28
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        double phone = 3999;
        double mo = 9.9;
        double zhe = 0.98;
        //        System.out.println(0.98*(phone+mo*2));
        BigDecimal bd1 = BigDecimal.valueOf(phone);
        BigDecimal bd2 = BigDecimal.valueOf(mo*2);
        BigDecimal bd3 = BigDecimal.valueOf(zhe);
        BigDecimal bd4 =bd1.add(bd2);
        BigDecimal bd5 = bd4.multiply(bd3);
        System.out.println("原价:" + bd4.doubleValue());
        System.out.println("现价："+bd5.setScale(2, RoundingMode.HALF_UP));
    }

}
