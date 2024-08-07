package com.example.coding.lec经典150.哈希;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class 最长连续序列 {
    public static void main(String[] args) {
        int[] nums = {4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3};
        int count = method1(nums);
        System.out.println(count);
    }

    public static int method1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 1;
        int index = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(index, 1);
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length) {
                int val = nums[i + 1] - nums[i];
                if (val == 0) {
                    continue;
                }
                if (val == 1) {
                    count = count + 1;
                    map.put(index, count);
                } else {
                    count = 1;
                    index = index + 1;
                    map.put(index, count);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Integer::compareTo);
        return list.get(list.size() - 1);
    }

    /**
     * 示例 1：
     *
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     *
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     */
}
