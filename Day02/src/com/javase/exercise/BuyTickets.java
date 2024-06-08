package com.javase.exercise;

import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/15:08
 * @Description: 买飞机票
 */
public class BuyTickets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double prePrice = sc.nextDouble();
        int preMonth = sc.nextInt();
        String place = sc.next();
//        double currentPrice = ;
        System.out.println("机票原价为：" + prePrice + " 月份为：" + preMonth + " 优惠后票价为：" + buyTickets(prePrice, preMonth, place));

    }

    public static double buyTickets(double price, int month, String place) {
        double discount = 0;
        if (month <= 10 && month >= 5) {
            switch (place) {
                case "头等舱":
                    discount = 0.9;
                    break;
                case "经济舱":
                    discount = 0.85;
                    break;
            }

        } else if ((month >= 1 && month <= 4) || (month >= 11 && month <= 12)) {
            switch (place) {
                case "头等舱":
                    discount = 0.7;
                    break;
                case "经济舱":
                    discount = 0.65;
                    break;
            }
        } else {
            System.out.println("月份输入有误");
            return 0;
        }
        //保留两位小数输出
        String temp = String.format("%.2f", price * discount);
        return Double.parseDouble(temp);
    }

}
