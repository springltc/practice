package com.example.coding.lec经典150.位运算.中等;


/**
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 */

/**
 * 示例 1：
 * 输入：left = 5, right = 7
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：left = 0, right = 0
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：left = 1, right = 2147483647
 * 输出：0
 */
//https://leetcode.cn/problems/bitwise-and-of-numbers-range/description/?envType=study-plan-v2&envId=top-interview-150
public class 数字范围按位与 {

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd2(5, 7));
    }

    /**
     * 我们观察按位与运算的性质。对于一系列的位，例如 [1,1,0,1,1]，只要有一个零值的位，那么这一系列位的按位与运算结果都将为零。
     */
    public static int rangeBitwiseAnd2(int left, int right) {
        //12 ->1100
        //13 ->1101
        //14 ->1110

        //->1100

        //12 ->1100
        //11 ->1011
        //12 & -12 = 0100

        while (left < right) {
            right = right - (right & -right);
        }
        return right;
    }

    /**
     * 超出时间限制
     * 注意:当left = 2147483647的时候 如果再加1 会变成负数-2147483648
     */
    public static int rangeBitwiseAnd(int left, int right) {
        if (left == right) {
            return left & right;
        }

        int sum = left;
        ++left;
        while (left <= right) {
            sum = sum & left;
            if (left == right) {
                break;
            }
            ++left;
            if (sum == 0) {
                return 0;
            }
        }
        return sum;
    }


}
