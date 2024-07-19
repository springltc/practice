package com.example.coding.lec经典150.二分查找.中等;

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
public class 搜索旋转排序数组 {

    public static void main(String[] args) {
        int[] nums = {3, 5, 1};
        int target = 3;
        int search = search(nums, target);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        //先升再降再升 N
        //中前 < target
        //中后 < target
        int l = 0, r = nums.length - 1, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            int val = nums[m];
            if (val == target) {
                return m;
            }
            if (m == nums.length - 1 || m == 0) {
                break;
            }
            //上升段 : 注意m + 1 <= nums.length - 2边界问题
            if (nums[m + 1] > nums[m]) {
                if (nums[m] > target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                //下降段
                if (nums[m] > target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }

}
