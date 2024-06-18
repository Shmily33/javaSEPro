package com.javase;

/**
 * @Author: gs_wang
 * @Date: 2024/06/18/下午1:57
 * @Description:
 */
public class Test5 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        test(nums, target);
        int leftIndex = getLeftIndex(nums, target);
        int rightIndex = getRightIndex(nums, target);
        System.out.println(leftIndex+" "+rightIndex);
    }
    public static int getRightIndex(int[] nums, int target) {
        // 二分查找该数据的位置。
        int start = 0;
        int end = nums.length - 1;
        int rs = -1; // 假设这个数据不存在
        while (start <= end) {
            int middle = (start + end) / 2;
            if(target > nums[middle]) {
                start = middle + 1;
            }else if(target < nums[middle]) {
                end = middle - 1;
            }else {
                // 找到这个数据出现在middle
                rs = middle;
                // 继续二分往右边再找找看
                start = middle + 1;
            }
        }
        return rs;
    }

    public static int getLeftIndex(int[] nums, int target) {
        // 二分查找该数据的位置。
        int start = 0;
        int end = nums.length - 1;
        int rs = -1; // 假设这个数据不存在
        while (start <= end) {
            int middle = (start + end) / 2;
            if(target > nums[middle]) {
                start = middle + 1;
            }else if(target < nums[middle]) {
                end = middle - 1;
            }else {
                // 找到这个数据出现在middle
                rs = middle;
                // 继续二分往左边再找找看
                end = middle - 1;
            }
        }
        return rs;
    }
    public static void test(int[]nums,int target){
        if (nums.length == 0) {
            System.out.println("[-1,-1]");
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int flag = -1;
        int end=0, start=0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                flag = mid;
                int temp=mid;
                start=mid;
                end=mid;
                while (mid + 1 < nums.length && nums[mid + 1] == target) {
                    end = mid + 1;
                    mid++;
                }
                while (temp - 1 > -1 && nums[temp - 1] == target) {
                    start = temp - 1;
                    temp--;
                }
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (flag == -1) {
            System.out.println("[-1,-1]");
            return;
        } else {
            System.out.println("["+start+","+end+"]");
        }
    }
}
