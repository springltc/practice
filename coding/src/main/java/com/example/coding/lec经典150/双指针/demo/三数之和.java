package com.example.coding.lec经典150.双指针.demo;

/**
 * @author liutc
 * @date 2024/2/7 10:52
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */

/**
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        //-4 -1 -1 0 1 2
        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            int start = i + 1;
            int end = length - 1;

            //-4 -1 -1 0 1 2
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);

                    if (set.add(list)) {
                        res.add(list);
                    }
                    start++;
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return res;
    }

}