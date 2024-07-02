package com.example.coding.lec经典150.数组和字符串.简单.demo;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Level;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 */
public class 多数元素 {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
//        int[] nums = {1};
        int i = majorityElement(nums);
        System.out.println(i);
        System.out.println(1 / 2);
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 效率不高
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            Integer count = map.get(nums[i]);
            if (Objects.nonNull(count)) {
                count = count + 1;
                if (count > (nums.length / 2)) {
                    return val;
                } else {
                    map.put(val, count);
                }
            } else {
                map.put(val, 1);
            }
        }
        return 0;
    }
}
