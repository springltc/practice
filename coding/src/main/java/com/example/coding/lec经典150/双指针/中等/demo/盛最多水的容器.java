package com.example.coding.lec经典150.双指针.中等.demo;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 */

/**
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
//https://leetcode.cn/problems/container-with-most-water/description/
public class 盛最多水的容器 {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int sV = height[start];
            int eV = height[end];
            if (sV > eV) {
                max = Math.max(max, (eV * (end - start)));
                end--;
            } else {
                max = Math.max(max, (sV * (end - start)));
                start++;
            }
        }

        return max;
    }

}
