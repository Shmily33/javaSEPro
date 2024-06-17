package com.javase.map;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * @Author: gs_wang
 * @Date: 2024/06/17/下午4:55
 * @Description:
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("1", 123.2);
        map.put("2", 1565.5);
        map.put("3", 445.1);

        // 1、键找值
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + "=>" + map.get(key));
        }
        // 2、键值对
        Set<Map.Entry<String, Double>> entries = map.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            System.out.println(entry.getKey() + "=>" + entry.getValue());
        }
        // 3、lambda
        map.forEach(new BiConsumer<String, Double>() {
            @Override
            public void accept(String k, Double v) { // 实际上还是以2方式实现
                System.out.println(k + "=>" + v);
            }
        });
        map.forEach((k, v) -> { // 简写
            System.out.println(k + "=>" + v);
        });

        Map<String, List<String>> map2 = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,"南京市","扬州市");
        map2.put("江苏省",arrayList);
        System.out.println(map2);


    }
}
