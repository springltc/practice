package com.example.coding.lec.数组和字符串.中等;

/**
 * @author liutc
 * @date 2024/5/21 11:14
 */
public class 轮转数组_超出时间限制 {
    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        rotate(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        for (int i = 0; i < k; i++) {
            swap(nums, length);
        }
    }

    public static void swap(int[] nums, int length) {
        int end = nums[length - 1];
        nums[length - 1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tem = nums[i];
            nums[i] = nums[length - 1];
            nums[length - 1] = tem;
        }
        nums[0] = end;
    }
}
