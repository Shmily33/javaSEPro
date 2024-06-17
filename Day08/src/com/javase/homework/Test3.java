package com.javase.homework;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/17/下午7:47
 * @Description:
 */
public class Test3 {
    public static void main(String[] args) {
        HashSet<User> hashSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名：");
            String name = sc.nextLine();
            System.out.println("请输入密码：");
            String password = sc.nextLine();
            User user = new User(name, password);
            if (hashSet.contains(user)) { // 需要重写User的hashCode和equals
                System.out.println("用户名重复，请重新输入~");
                System.out.println(hashSet);
            }else {
                hashSet.add(user);
            }
        }
    }
}
