package com.example.coding.lec经典150.数组和字符串.中等.demo;


/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */

import java.util.Arrays;
import java.util.HashMap;

/**
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 */
public class 除自身以外数组的乘积 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ints = productExceptSelf(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    /**
     * O(n) 时间复杂度内完成此题
     */
    private static int[] productExceptSelf(int[] nums) {
        int beforeSum = 1;
        int afterSum = 1;
        int length = nums.length;
        int[] anw = new int[length];
        Arrays.fill(anw, 1);
        for (int i = 0, j = length - 1; i < length; i++, j--) {
            anw[i] = anw[i] * beforeSum;
            beforeSum = beforeSum * nums[i];

            anw[j] = anw[j] * afterSum;
            afterSum = afterSum * nums[j];
        }

        return anw;
    }

}
