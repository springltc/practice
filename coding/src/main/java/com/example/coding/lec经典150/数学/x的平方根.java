package com.example.coding.lec经典150.数学;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * <p>
 * 提示：
 * 0 <= x <= 231 - 1
 */
//https://leetcode.cn/problems/sqrtx/description/?envType=study-plan-v2&envId=top-interview-150
public class x的平方根 {

    public static void main(String[] args) {
        int x = 2147395599;
        int sqrt = mySqrt(x);
        System.out.println(sqrt);
    }

    //二分查找
    public static int mySqrt(int x) {
        int l = 0, r = x, m = 0, aws = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if ((long) m * m <= x) {
                aws = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return aws;
    }
}
