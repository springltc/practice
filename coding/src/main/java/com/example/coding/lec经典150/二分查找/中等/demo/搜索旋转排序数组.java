package com.example.coding.lec经典150.二分查找.中等.demo;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 */
//https://leetcode.cn/problems/search-in-rotated-sorted-array/submissions/548737446/?envType=study-plan-v2&envId=top-interview-150
public class 搜索旋转排序数组 {

    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        int target = 3;
        int search = search(nums, target);
        System.out.println(search);
    }

    //nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转
    //通过中间值和l和r位置的值判断是左边的升序 还是 右边的升序
    //左边升序的话
    //nums = [4,5,6,7,0,1,2], target = 0
    private static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m = 0;
        int index = -1;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            }

            //左升
            if (nums[m] >= nums[l]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = l + 1;
                }
            } else {
                //右升
                if (target <= nums[r] && target > nums[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return index;
    }

}
