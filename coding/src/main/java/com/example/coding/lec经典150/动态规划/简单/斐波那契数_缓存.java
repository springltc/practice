package com.example.coding.lec经典150.动态规划.简单;

import java.util.Arrays;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 */
public class 斐波那契数_缓存 {

    public int fib(int n) {
        int[] bp = new int[n + 1];
        Arrays.fill(bp, -1);
        return calculate(n, bp);
    }


    public int calculate(int n, int[] bp) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (bp[n] != -1) {
            return bp[n];
        }
        int aws = calculate(n - 1, bp) + calculate(n - 2, bp);
        bp[n] = aws;
        return aws;
    }
}
