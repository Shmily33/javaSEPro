package com.javase.param;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: gs_wang
 * @Date: 2024/06/17/下午4:21
 * @Description:
 */
public class ParamTest {
    public static void main(String[] args) {
        test();
        test(10);
        test(10,20,30);
        test(new int[]{1,2,3,4,5,6,7,8,9});
        ArrayList<String> arrayList = new ArrayList<>();
    }

    public static void test(int...nums){
        // 可变参数在方法内部是数组
        System.out.println(Arrays.toString(nums));
    }

}
