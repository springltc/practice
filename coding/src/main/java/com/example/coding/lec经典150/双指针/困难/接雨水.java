package com.example.coding.lec经典150.双指针.困难;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 */

/**
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 */

/**
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
//https://leetcode.cn/problems/trapping-rain-water/
public class 接雨水 {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap2(height);
        System.out.println(trap);
    }

    public static int trap2(int[] height) {
        int start = 1, end = height.length - 2, lmax = height[0], rmax = height[height.length - 1];
        int aws = 0;
        while (start <= end) {
            if (lmax >= rmax) {
                aws += Math.max(0, rmax - height[end]);
                rmax = Math.max(rmax, height[end--]);
            } else {
                aws += Math.max(0, lmax - height[start]);
                lmax = Math.max(lmax, height[start++]);
            }
        }

        return aws;
    }

    public static int trap(int[] height) {
        int n = height.length;
        //左侧最大值
        int[] maxL = new int[n];
        maxL[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxL[i] = Math.max(height[i], maxL[i - 1]);
        }
        //右侧最大值
        int[] maxR = new int[n];
        maxR[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxR[i] = Math.max(height[i], maxR[i + 1]);
        }

        int aws = 0;
        for (int i = 1; i < n - 1; i++) {
            aws = aws + Math.max(0, Math.min(maxL[i - 1], maxR[i + 1]) - height[i]);
        }

        return aws;
    }
}
