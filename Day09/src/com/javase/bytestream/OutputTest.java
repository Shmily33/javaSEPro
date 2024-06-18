package com.javase.bytestream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @Author: gs_wang
 * @Date: 2024/06/18/下午8:31
 * @Description:
 */
public class OutputTest {
    public static void main(String[] args) throws Exception {
        FileOutputStream os =
                new FileOutputStream("E:/桌面/javaPro/javaProjects/javaSEPro/Day09/src/java02.txt",true);
        os.write(97); // 代表a
        os.write('b');

        byte[] bytes = "我爱你中国abc".getBytes();
        os.write(bytes);

        os.write(bytes,0,15);

        // 换行符
        os.write("\r\n".getBytes());

        os.close();

    }
}
