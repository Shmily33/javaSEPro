package com.javase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * @Author: gs_wang
 * @Date: 2024/06/18/上午9:46
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        Random r = new Random();
        while (hashSet.size() < 10) {
            hashSet.add(r.nextInt(200) + 1);
        }
        System.out.println(hashSet);

        while (hashSet.size() != 1) {
            ArrayList<Integer> list = new ArrayList<>(hashSet);
            for (int i = 0; i < list.size(); i++) {
                if ((i + 1) % 2 != 0) {
                    hashSet.remove(list.get(i));
                }
            }
            System.out.println("----"+hashSet);
        }

        System.out.println("最后留下的是：" + hashSet);
    }

    private static boolean isPrime(int i) {
        if (i == 1) return true;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
