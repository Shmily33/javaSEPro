package com.javase.homework;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.math.BigDecimal;

/**
 * @Author: gs_wang
 * @Date: 2024/06/15/下午5:44
 * @Description:
 */
public class Test2 {

    public static void main(String[] args) {
        double a = 0.01;
        double b = 0.05;
        System.out.println(a / b);
        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);
        System.out.println(a1.divide(b1));
    }
}
