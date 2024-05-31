package com.example.coding.lec热题100.简单.哈希;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liutc
 * @date 2024/5/31 11:16
 */
public class 最长连续序列 {

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        int i = longestConsecutive(nums);
        System.out.println(i);
    }

    //可能会有相同的元素
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int current = 1;
                int currentNum = num;

                while (set.contains(currentNum + 1)) {
                    current++;
                    currentNum++;
                }

                longest = Math.max(current, longest);
            }
        }

        return longest;
    }
}
