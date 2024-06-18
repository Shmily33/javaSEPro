package com.javase.bytestream;

import java.io.*;

/**
 * @Author: gs_wang
 * @Date: 2024/06/18/下午8:42
 * @Description:
 */
public class CopeTest {
    public static void main(String[] args) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("E:\\桌面\\javaPro\\javaProjects\\javaSEPro\\Day09\\src\\img.png");
            os = new FileOutputStream("E:\\桌面\\javaPro\\javaProjects\\javaSEPro\\Day09\\src\\copy.png");
            byte[] buffer = new byte[1024];
            int len; // 记住每次读取多少字节
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            System.out.println("复制完成");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (os != null) os.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
