package com.example.coding.lec经典150.位运算.中等;

/**
 * 数组中只有1种数出现次数少于m次，其他数都出现了m次
 *
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 示例 1：
 *
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 */
public class 只出现一次的数字II {

    //3 1
    //6 2
    public static void main(String[] args) {

    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer value = entry.getValue();
            if (value == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
