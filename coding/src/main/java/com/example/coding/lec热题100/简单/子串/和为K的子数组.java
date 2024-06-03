package com.example.coding.lec热题100.简单.子串;

/**
 * @author liutc
 * @date 2024/6/3 17:11
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 */

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 */

import java.util.HashMap;

/**
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * ---> nums[0,1] 、nums[1,2]两个连续子数组
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class 和为K的子数组 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        int sum = subarraySum(nums, k);
        System.out.println(sum);
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
