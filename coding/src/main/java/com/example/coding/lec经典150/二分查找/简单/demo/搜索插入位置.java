package com.example.coding.lec经典150.二分查找.简单.demo;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 */
//https://leetcode.cn/problems/search-insert-position/?envType=study-plan-v2&envId=top-interview-150
public class 搜索插入位置 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 7, 8, 9};
        int target = 11;
        int searchInsert = searchInsert(nums, target);
        System.out.println(searchInsert);
    }

    /**
     * 题目分析的能力 它将会被按顺序插入的位置,结和 nums 为 无重复元素 的 升序 排列数组 -->判断出该题目的意思是找>=target的小标
     * 临界点
     * --如果第一个元素>target 则返回0->程序自动满足,无需添加这个判断
     * --如果最后一个元素<target,则返回num.length
     *
     * @param nums
     * @param target
     * @return
     */
    private static int searchInsert(int[] nums, int target) {
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        int l = 0, r = nums.length - 1, m = 0;
        int index = -1;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m - 1;
                index = m;
            } else {
                l = m + 1;
            }
        }
        return index;
    }

}
