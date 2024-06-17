package com.javase.homework;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Author: gs_wang
 * @Date: 2024/06/17/下午7:29
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        Random random = new Random();
        while (hashSet.size() < 6) {
            hashSet.add(random.nextInt(32) + 1);
        }
        System.out.println(hashSet);
        // Collections的sort不能对Set排序：1、赋值转为ArrayList 2、Stream
        List<Integer> collect = hashSet.stream().sorted().collect(Collectors.toList());
        collect.add(random.nextInt(16) + 1);

        System.out.println(collect);
    }
}
