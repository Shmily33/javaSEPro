package com.javase.homework;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: gs_wang
 * @Date: 2024/06/17/下午8:10
 * @Description:
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new HashMap<>();
        while (true) {
            String str = sc.nextLine();
            if (str.equals("end")) break;
            if (hashMap.containsKey(str)) {
                hashMap.put(str, hashMap.get(str) + 1);
            } else {
                hashMap.put(str, 1);
            }
        }
        // 1、Set+Stream直接输出(升序)
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        entrySet.stream().sorted(((o1, o2) -> Double.compare(o1.getValue(), o2.getValue())))
                .forEach(a -> System.out.println(a.getKey() + "售出的数量 " + a.getValue()));
        // 2、new ArrayList<>(hashMap.entrySet()).var (倒序)
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(hashMap.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
//        hashMap.forEach((k, v) -> System.out.println(k + "售出的数量： " + v));

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) { // 为了按照倒序的格式返回出去需要一个LinkedHashMap
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        linkedHashMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
