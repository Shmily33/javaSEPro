package com.javase.homework;

import java.util.HashMap;
import java.util.Set;

/**
 * @Author: gs_wang
 * @Date: 2024/06/17/下午8:47
 * @Description:
 */
public class Test5 {
    public static void main(String[] args) {
        HashMap<String, String> javaSE = new HashMap<>();
        javaSE.put("001", "wgs1");
        javaSE.put("002", "wgs2");
        HashMap<String, String> javaEE = new HashMap<>();
        javaEE.put("001", "wgs3");
        javaEE.put("002", "wgs4");
        HashMap<String, HashMap<String, String>> map = new HashMap<>();
        map.put("javaSE", javaSE);
        map.put("javaEE", javaEE);
        map.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((k2, v2) -> {
                System.out.println("\t" + k2 + "--" + v2);
            });
        });
    }
}
