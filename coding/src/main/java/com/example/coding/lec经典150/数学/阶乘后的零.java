package com.example.coding.lec经典150.数学;

/**
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * <p>
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * <p>
 * 示例 3：
 * 输入：n = 0
 * 输出：0
 * <p>
 * 提示：
 * 0 <= n <= 10的四次方
 */
//https://leetcode.cn/problems/factorial-trailing-zeroes/description/?envType=study-plan-v2&envId=top-interview-150
public class 阶乘后的零 {

    public static void main(String[] args) {
        int n = 5;
        int zeroes = trailingZeroes(n);
        System.out.println(zeroes);
    }

    public static int trailingZeroes(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                ++ans;
            }
        }
        return ans;
    }
}
