package com.example.coding.lec经典150.滑动窗口;

import org.checkerframework.checker.units.qual.Length;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
//https://leetcode.cn/problems/minimum-size-subarray-sum/description/
public class 长度最小的子数组 {

    public int minSubArrayLen(int target, int[] nums) {
        int aws = Integer.MAX_VALUE;
        for (int l = 0, r = 0, sum = 0; r < nums.length; r++) {
            sum = sum + nums[r];
            while (sum - nums[l] >= target) {
                sum = sum - nums[l++];
            }
            if (sum >= target) {
                aws = Math.min(aws, r - l + 1);
            }
        }

        return aws == Integer.MAX_VALUE ? 0 : aws;
    }

}
