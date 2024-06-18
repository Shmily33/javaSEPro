package com.javase.trycatch;

import java.io.*;

/**
 * @Author: gs_wang
 * @Date: 2024/06/18/下午8:42
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
//         is = null;
//         os = null;
        try (
                InputStream is = new FileInputStream("E:\\桌面\\javaPro\\javaProjects\\javaSEPro\\Day09\\src\\img.png");
                OutputStream os = new FileOutputStream("E:\\桌面\\javaPro\\javaProjects\\javaSEPro\\Day09\\src\\copy.png");
        ) {

            byte[] buffer = new byte[1024];
            int len; // 记住每次读取多少字节
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            System.out.println("复制完成");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
