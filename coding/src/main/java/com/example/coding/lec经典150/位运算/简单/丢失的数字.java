package com.example.coding.lec经典150.位运算.简单;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */

import java.util.Arrays;

/**
 * 示例 1：
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 4：
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 */
//https://leetcode.cn/problems/missing-number/description/
public class 丢失的数字 {

    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int number = missingNumber(nums);
        System.out.println(number);
    }

    public static int missingNumber2(int[] nums) {
        int sum = 0;
        for (int i = 0; i <= nums.length; i++) {
            sum = sum ^ i;
        }

        for (int i = 0; i < nums.length; i++) {
            sum = sum ^ nums[i];
        }

        return sum;
    }

    public static int missingNumber(int[] nums) {
        if (nums.length == 1 && nums[0] == 0) {
            return 1;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] ^ i) != 0) {
                return nums[i] - 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }
}
