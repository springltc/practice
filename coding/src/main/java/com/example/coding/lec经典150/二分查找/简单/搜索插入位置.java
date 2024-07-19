package com.example.coding.lec经典150.二分查找.简单;

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
public class 搜索插入位置 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 7, 8, 9};
        int target = 11;
        int searchInsert = searchInsert(nums, target);
        System.out.println(searchInsert);
    }

    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 相当于求>=target-1的最左小标
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
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
        //不存在的情况
        if (aws == -1) {
            return nums.length;
        }

        return aws;
    }
}
