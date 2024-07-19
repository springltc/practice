package com.example.coding.lec经典150.二分查找.中等;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 */

/**
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 */
public class 寻找峰值 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int peakElement = findPeakElement(nums);
        System.out.println(peakElement);
    }

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        //     .
        //   .   .
        //  .      .

        int l = 1, r = nums.length - 2, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] < nums[m - 1]) {
                r = m - 1;
            } else if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                return m;
            }
        }

        return m;
    }
}
