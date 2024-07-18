package com.example.coding.lec经典150.双指针.中等;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */

import java.util.Arrays;

/**
 * 示例 1：
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * <p>
 * 示例 3 :
 * 输入：nums = [3,3,3,3,3]
 * 输出：3
 */
//https://leetcode.cn/problems/find-the-duplicate-number/submissions/547619523/
public class 寻找重复数 {

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        int duplicate = findDuplicate3(nums);
        System.out.println(duplicate);
    }

    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == val) {
                return val;
            } else {
                val = nums[i];
            }
        }
        return -1;
    }

    public static int findDuplicate3(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }

        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

    //nums = [3,1,3,4,2]
    public static int findDuplicate2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 相遇了，快指针回开头
        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
