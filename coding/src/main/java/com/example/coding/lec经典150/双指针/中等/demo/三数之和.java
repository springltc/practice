package com.example.coding.lec经典150.双指针.中等.demo;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * <p>
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
//https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-interview-150
public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        List<List<Integer>> list = threeSum(nums);
        System.out.println(list);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int v1 = nums[i];

            if (v1 > 0) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int v2 = nums[start];
                int v3 = nums[end];
                int sum = v1 + v2 + v3;

                if (sum == 0) {
                    List<Integer> rr = new ArrayList<>();
                    rr.add(v1);
                    rr.add(v2);
                    rr.add(v3);

                    String newKey = "" + v1 + v2 + v3;
                    if (set.add(newKey)) {
                        list.add(rr);
                    }
                    start++;
                    end--;
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return list;
    }
}
