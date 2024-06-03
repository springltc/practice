package com.example.coding.lec热题100.简单.双指针;

/**
 * @author liutc
 * @date 2024/5/31 17:06
 */

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class 接雨水 {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};


    }

    public int trap(int[] height) {
        int sum = 0;
        int max_left = 0;
        int[] max_right = new int[height.length];

        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            max_left = Math.max(max_left, height[i - 1]);
            int min = Math.min(max_left, max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

}
