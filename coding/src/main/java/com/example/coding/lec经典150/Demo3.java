package com.example.coding.lec经典150;

import java.util.Arrays;

/**
 * @author liutc
 * @date 2025/1/8 14:48
 */
public class Demo3 {

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 3, 2};
        int subarray = longestMonotonicSubarray(nums);
        System.out.println(subarray);
    }

    public static int longestMonotonicSubarray(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;
        int min = nums[0];
        int count = 1;
        int sumIncrement = 1;
        for (int i = 1; i < length; i++) {
            int val = nums[i];
            if (val > min) {
                count++;
                sumIncrement = Math.max(sumIncrement, count);
            } else {
                if (val == min){

                }
                count = 1;
            }
            min = val;
        }

        int sumDesc = 1;
        int max = nums[length - 1];
        count = 1;
        for (int i = length - 2; i >= 0; i--) {
            int val = nums[i];
            if (val < max) {
                count++;
                sumDesc = Math.max(sumDesc, count);
            } else {
                count = 1;
            }
            max = val;
        }

        return Math.max(sumDesc, sumIncrement);
    }
}
