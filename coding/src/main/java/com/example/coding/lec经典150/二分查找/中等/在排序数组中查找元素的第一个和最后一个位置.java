package com.example.coding.lec经典150.二分查找.中等;

import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        int[] nums = {3, 3, 3};
        int target = 3;
        int[] searchRange = searchRange(nums, target);
        String string = Arrays.toString(searchRange);
        System.out.println(string);
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
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

        if (aws == -1 || nums[aws] != target) {
            return new int[]{-1, -1};
        } else {
            int lastR = aws;
            for (int i = aws + 1; i < nums.length; i++) {
                if (nums[i] == target) {
                    lastR = i;
                } else {
                    break;
                }
            }
            return new int[]{aws, lastR};
        }
    }

}
