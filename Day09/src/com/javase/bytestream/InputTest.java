package com.javase.bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author: gs_wang
 * @Date: 2024/06/18/下午8:01
 * @Description:
 */
public class InputTest {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("E:\\桌面\\javaPro\\javaProjects\\javaSEPro\\Day09\\src\\java01.txt");

        File f = new File("javaSEPro\\Day09\\src\\java01.txt");
        long size = f.length();
        byte[] buffer = new byte[(int) size];

        int len = is.read(buffer);
        System.out.println(new String(buffer));
        System.out.println(size);
        System.out.println(len);

        byte[] bytes = is.readAllBytes();
        System.out.println(new String(bytes));// 文件过大不行
    }
}
