package com.example.coding.lec经典150.位运算.简单;

/**
 * @author liutc
 * @date 2024/7/15 08:51
 * <p>
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 x 使得 n == 2的x次方 ，则认为 n 是 2 的幂次方。
 */

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2的x次方 ，则认为 n 是 2 的幂次方。
 */

/**
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：true
 * 解释：2的0次方 = 1
 * 示例 2：
 *
 * 输入：n = 16
 * 输出：true
 * 解释：2的四次方 = 16
 * 示例 3：
 *
 * 输入：n = 3
 * 输出：false
 */
public class 二的幂 {
    //10101100
    //01010011+1
    //01010100
    //10101100//&后
    //00000100
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        //n&-n是提取最右侧的1
        return n == (n & -n);
    }
}
