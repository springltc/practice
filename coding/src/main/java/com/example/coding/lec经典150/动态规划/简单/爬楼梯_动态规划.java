package com.example.coding.lec经典150.动态规划.简单;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * 1 <= n <= 45
 */
//https://leetcode.cn/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-interview-150
public class 爬楼梯_动态规划 {

    public static void main(String[] args) {
        int n = 45;
        int stairs = climbStairs(n);
        System.out.println(stairs);
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int lastLast = 1;
        int last = 2;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = lastLast + last;
            lastLast = last;
            last = cur;
        }
        return cur;
    }
}
