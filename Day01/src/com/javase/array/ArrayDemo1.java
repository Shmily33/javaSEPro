package com.javase.array;

import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/07/16:56
 * @Description: 某歌唱比赛，需要开发一个系统：可以录入6名评委的打分，录入完毕后立即输出平均分做为选手得分
 */
public class ArrayDemo1 {
    public static void main(String[] args) {
        double[] score = new double[6];
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        for (int i = 0; i < 6; i++) {
            score[i] = sc.nextDouble();

        }
        for (double s : score) {
            sum += s;
        }
        System.out.println("总分数是：" + sum/6);
    }

}
