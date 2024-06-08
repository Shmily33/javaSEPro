package com.javase.exercise;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/16:02
 * @Description:
 */
public class JudgeAverageScore {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("评委人数：");
        int num = sc.nextInt();
        judgeAverageScore(num);

    }

    public static void judgeAverageScore(int num) {
        int[] scores = new int[num];
        Random random = new Random();
        //随机分数
        for (int i = 0; i < num; i++) {
            scores[i] = random.nextInt(101);//0-100
        }
        System.out.println("评分分数为：");
        int max = scores[0];
        int min = scores[0];
        int sum = 0;
        for (int s : scores) {
            System.out.print(s + " ");
            if (s > max) {
                max = s;
            }
            if (s < min) {
                min = s;
            }
            sum += s;
        }
        System.out.println("最大值为：" + max + " 最小值为：" + min);
        double avg = (double) (sum - max - min) / (num - 2);
        System.out.println("去除最大最小后平均分为：" + avg);
    }

}
