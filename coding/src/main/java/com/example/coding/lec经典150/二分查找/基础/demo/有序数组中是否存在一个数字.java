package com.example.coding.lec经典150.二分查找.基础.demo;

/**
 * @author liutc
 * @date 2024/7/19 11:29
 */
public class 有序数组中是否存在一个数字 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 3;
        boolean exist = exist(nums, target);
        System.out.println(exist);
    }

    public static boolean exist(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                return true;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
