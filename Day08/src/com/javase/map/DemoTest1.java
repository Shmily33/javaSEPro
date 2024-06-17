package com.javase.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: gs_wang
 * @Date: 2024/06/17/下午5:06
 * @Description:
 */
public class DemoTest1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "A", "B", "C", "D", "A", "B", "B", "C", "A", "B", "D", "D", "E", "F");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("B", 0);
        map.put("C", 0);
        map.put("D", 0);
        for (String s : arrayList) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
//        map.forEach((k, v) -> {
//            System.out.println(k + "===>" + v);
//        });
        System.out.println(map);
    }
}
