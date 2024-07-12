package com.example.coding.lec经典150.位运算.简单.demo;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 */

/**
 * 示例 1：
 * <p>
 * 输入：n = 00000010100101000001111010011100
 * 输出：964176192 (00111001011110000010100101000000)
 * 解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 */
public class 颠倒二进制位 {

    public static void main(String[] args) {
        System.out.println();

        int n = 43261596;
        int bits = reverseBits(n);
        System.out.println(bits);
    }

    //00000010100101000001111010011100
    public static int reverseBits(int n) {
        int aws = 0;
        for (int i = 0; i < 32; i++) {
            aws = aws | (n & 1) << (31 - i);
            n = n >> 1;
        }
        return aws;
    }
}
