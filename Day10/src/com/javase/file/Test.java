package com.javase.file;

import java.io.FileReader;
import java.util.Properties;

/**
 * @Author: gs_wang
 * @Date: 2024/06/19/15:31
 * @Description:
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("Day10\\src\\users.properties"));
        System.out.println(properties);
    }
}
