package com.example.coding.lec经典150.二分查找.基础;

/**
 * @author liutc
 * @date 2024/7/19 13:06
 */
public class 有序数组中找大于等于num的最左位置 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 5, 5, 6};
        int target = 5;
        int left = findLeft(nums, target);
        System.out.println(left);
    }

    public static int findLeft(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1, m = 0;
        int aws = -1;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m - 1;
                aws = m;
            } else {
                l = m + 1;
            }
        }
        return aws;
    }
}
