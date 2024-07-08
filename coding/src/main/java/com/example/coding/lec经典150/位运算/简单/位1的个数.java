package com.example.coding.lec经典150.位运算.简单;


/**
 * 编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中设置位的个数（也被称为汉明重量）。
 */

/**
 * 示例 1：
 * 输入：n = 11
 * 输出：3
 * 解释：输入的二进制串 1011 中，共有 3 个设置位。
 * 示例 2：
 * <p>
 * 输入：n = 128
 * 输出：1
 * 解释：输入的二进制串 10000000 中，共有 1 个设置位。
 * <p>
 * 示例 3：
 * 输入：n = 2147483645
 * 输出：30
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 30 个设置位。
 */

public class 位1的个数 {

    public static void main(String[] args) {
//        System.out.println(1&1);
//        System.out.println(1&0);
//
//        //
//        System.out.println("+=========+");
//        System.out.println(1<<0);
//        System.out.println(1<<1);
//        System.out.println(1<<2);

        int weight = hammingWeight(11);
        System.out.println(weight);
    }

    /**
     * 1 << i  相当于 1*2的零次方
     * 注意:
     * (n & (1 << i)) == 1 和 (n & (1 << i)) != 0 是有区别的
     */
    /**
     * 19 的二进制表示是 10011，2 的二进制表示是 10。
     * 进行按位与操作，得到： 10011 AND 00010
     * 00010
     * 所以，19 & 2 的结果是 2。
     */
    public static int hammingWeight(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                sum++;
            }
        }
        return sum;
    }

}
