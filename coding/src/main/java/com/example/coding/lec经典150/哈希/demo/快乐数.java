package com.example.coding.lec经典150.哈希.demo;


/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 示例 1：
 * <p>
 * 输入：n = 19
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：false
 */
public class 快乐数 {

    public static void main(String[] args) {
        boolean happy = isHappy( 2);
        System.out.println(happy);
    }

    public static boolean isHappy(int n) {
        Set<Integer> sets = new HashSet<>();
        return handler(sets, n);
    }

    public static boolean handler(Set<Integer> sets, int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            Integer val = Integer.valueOf(chars[i] + "");
            sum = sum + (int) Math.pow(val, 2);
        }

        if (sum == 1) {
            return true;
        }

        if (sets.contains(sum)) {
            return false;
        }

        sets.add(sum);
        return handler(sets, sum);
    }

}
