package com.javase.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/12/14:58
 * @Description: 菜品上架操作类
 */
public class FoodOperator {
    // 定义一个ArrayList集合,负责存储商品信息
    private ArrayList<Food> foodList = new ArrayList<>();

    public void addFood() {
        // 创建菜品对象，封装上架信息
        Food food = new Food();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the food: ");
        String name = sc.next();
        food.setName(name);
        System.out.println("Enter the price of the food: ");
        double price = sc.nextDouble();
        food.setPrice(price);
        System.out.println("Enter the description of the food: ");
        String description = sc.next();
        food.setDesc(description);
        foodList.add(food);
        System.out.println("Success!");
    }

    //展示菜品信息
    public void displayFood() {
        if (foodList.isEmpty()) {
            System.out.println("No food found! 请先上架菜品~");
            return;
        }
        for (Food food : foodList) {
            System.out.println("Name: " + food.getName() + ", Price: " + food.getPrice() + ", Desc: " + food.getDesc());
        }
        System.out.println("Display completed!");
    }

    //负责展示操作界面
    public void start() {
        while (true) {
            System.out.println("请选择功能：1-上架菜品 2-展示菜品 3-退出");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您的操作：");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    addFood();
                    break;
                case "2":
                    displayFood();
                    break;
                case "3":
                    System.out.println("退出程序");
                    return;
                default:
                    System.out.println("输入的命令不存在~");
            }
        }

    }

}
