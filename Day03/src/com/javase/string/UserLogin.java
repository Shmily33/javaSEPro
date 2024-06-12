package com.javase.string;

import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/12/10:45
 * @Description:
 */
public class UserLogin {
    // 完成用户登录功能
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {

            System.out.println("用户名：");
            String name = sc.next();
            System.out.println("密码：");
            String password = sc.next();
            boolean login = login(name, password);
            if (login) {
                System.out.println("登录成功");
                break;
            } else {
                System.out.println("用户名或密码错误");
            }
        }

    }

    public static boolean login(String name, String password) {
        String rightName = "ithema";
        String rightPassword = "123456";
        return name.equals(rightName) && password.equals(rightPassword);
    }


}
