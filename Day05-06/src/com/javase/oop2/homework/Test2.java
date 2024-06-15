package com.javase.oop2.homework;

/**
 * @Author: gs_wang
 * @Date: 2024/06/14/下午8:46
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        TV tv = new TV("东方卫视");
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.controlTV(tv);
    }
}
