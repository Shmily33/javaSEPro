package com.javase.oop2.homework;

import java.util.Scanner;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午8:44
 * @Description:
 */
public class RemoteControl {
    public void controlTV(TV tv){
        System.out.println("遥控器控制电视");
        Scanner sc = new Scanner(System.in);
        tv.play(sc.next());
    }
}
