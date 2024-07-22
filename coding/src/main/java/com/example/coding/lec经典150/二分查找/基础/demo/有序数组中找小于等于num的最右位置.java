package com.example.coding.lec经典150.二分查找.基础.demo;

/**
 * @author liutc
 * @date 2024/7/19 13:07
 */
public class 有序数组中找小于等于num的最右位置 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 5, 5, 6};
        int target = 5;
        int left = findRight(nums, target);
        System.out.println(left);
    }

    private static int findRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m = 0;
        int index = -1;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] <= target) {
                l = m + 1;
                index = m;
            } else {
                r = m - 1;
            }
        }
        return index;
    }


}
