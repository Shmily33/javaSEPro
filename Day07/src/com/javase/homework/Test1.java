package com.javase.homework;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author: gs_wang
 * @Date: 2024/06/16/下午9:57
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("郭靖");
        names.add("黄蓉");
        names.add("黄药师");
        names.add("老顽童");
        names.add("某人");
        ArrayList<String> actions = new ArrayList<>();
        actions.add("吃芥末");
        actions.add("学羊叫");
        actions.add("做俯卧撑");
        actions.add("喝啤酒");
        actions.add("蛙跳");
        Random rd = new Random();
        for (String name : names) {
            int i = rd.nextInt(actions.size());
            String action = actions.get(i);
            System.out.println(name+"抽到的签："+action);
            actions.remove(action);
        }


    }
}
