package com.example.coding.lec经典150.双指针.简单;

/**
 * 给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
 * <p>
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
 * <p>
 * 你可以返回 任何满足上述条件的数组作为答案
 */

import java.util.Arrays;

/**
 * 示例 1：
 * 输入：nums = [4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * 示例 2：
 * 输入：nums = [2,3]
 * 输出：[2,3]
 */
//https://leetcode.cn/problems/sort-array-by-parity-ii/description/
public class 按奇偶排序数组II {
    public static void main(String[] args) {
        int[] nums = {2, 3};
        int[] array = sortArrayByParityII2(nums);
        System.out.println(Arrays.toString(array));
    }

    public static int[] sortArrayByParityII2(int[] nums) {
        int oneIndex = 1;
        int twoIndex = 0;
        int n = nums.length - 1;
        while (oneIndex <= n && twoIndex <= n) {
            if (nums[n] % 2 == 0) {
                int tem = nums[n];
                nums[n] = nums[twoIndex];
                nums[twoIndex] = tem;

                twoIndex = twoIndex + 2;
            } else {
                int tem = nums[n];
                nums[n] = nums[oneIndex];
                nums[oneIndex] = tem;

                oneIndex = oneIndex + 2;
            }
        }

        return nums;
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int oneIndex = 1;
        int twoIndex = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num % 2 == 0) {
                res[twoIndex] = num;
                twoIndex = twoIndex + 2;
            } else {
                res[oneIndex] = num;
                oneIndex = oneIndex + 2;
            }
        }
        return res;
    }
}
