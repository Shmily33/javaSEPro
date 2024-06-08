package com.javase.method;

/**
 * @Author: gs_wang
 * @Date: 2024/06/08/上午9:52
 * @Description:
 */
public class MethodDemo1 {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 22, 33, 44, 55};
        //打印int类型数组内容
        printArray(arr);

        //判断两个数组是否一样
        int[] arr1 = new int[]{10, 20, 30};
        int[] arr2 = new int[]{10, 21, 30};
        System.out.println(checkIsSame(arr1, arr2));

        //找出数组最大值
        int[] arr3 = new int[]{11, 22, 33, 44, 55, 0, 55636};
        System.out.println(Max(arr3));


    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static boolean checkIsSame(int[] arr1, int[] arr2) {
        boolean flag = false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) {
                flag = true;
            } else {
                return false;
            }
        }
        return flag;
    }

    public static int Max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}
