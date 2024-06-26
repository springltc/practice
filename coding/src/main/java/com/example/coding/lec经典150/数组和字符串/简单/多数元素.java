package com.example.coding.lec经典150.数组和字符串.简单;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */

import java.util.Arrays;
import java.util.HashMap;

/**
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 */
public class 多数元素 {

    public static void main(String[] args) {
//        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int[] nums = {1};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        return m3(nums);
    }

    public static int m4(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int m3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int val = nums.length / 2 + 1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                int newC = count + 1;
                if (newC >= val) {
                    return num;
                }
                map.put(num, newC);
            }
        }

        return 0;
    }

    public static int m2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 不好的实现
     * @param nums
     * @return
     */
    public static int m1(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int val = nums.length / 2 + 1;
        int count = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == result) {
                count++;
                if (count >= val) {
                    return result;
                }
            } else {
                result = nums[i];
                count = 1;
            }
        }

        return result;
    }
}
