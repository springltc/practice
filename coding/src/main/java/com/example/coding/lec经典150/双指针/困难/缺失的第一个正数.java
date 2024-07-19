package com.example.coding.lec经典150.双指针.困难;

import java.util.Arrays;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * --> 最小的正整数是1
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * <p>
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 * <p>
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 */
public class 缺失的第一个正数 {

    public static void main(String[] args) {
        int[] nums = {0, 2, 2, 1, 1};
        int positive = firstMissingPositive(nums);
        System.out.println(positive);
    }

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        boolean find = false;
        int val = 0;
        for (int i = 0; i < nums.length; i++) {
            if (find) {
                //0, 2, 2, 1, 1 重复的处理
                if (nums[i] == val - 1) {
                    continue;
                }

                if (nums[i] != val) {
                    return val;
                } else {
                    val = val + 1;
                }
            } else {
                if (nums[i] == 1) {
                    find = true;
                    val = 2;
                }
            }
        }

        return find ? val : 1;
    }

    /**
     * 左神的双指针解法
     */
    public static int firstMissingPositive2(int[] arr) {
        // l的左边，都是做到i位置上放着i+1的区域
        // 永远盯着l位置的数字看，看能不能扩充(l++)
        int l = 0;
        // [r....]垃圾区
        // 最好的状况下，认为1~r是可以收集全的，每个数字收集1个，不能有垃圾
        // 有垃圾呢？预期就会变差(r--)
        int r = arr.length;
        while (l < r) {
            if (arr[l] == l + 1) {
                l++;
            } else if (arr[l] <= l || arr[l] > r || arr[arr[l] - 1] == arr[l]) {
                swap(arr, l, --r);
            } else {
                swap(arr, l, arr[l] - 1);
            }
        }
        return l + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
