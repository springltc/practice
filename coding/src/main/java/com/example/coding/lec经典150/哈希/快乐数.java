package com.example.coding.lec经典150.哈希;


/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 示例 1：
 *
 输入：n = 19
 输出：true
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：false
 */
public class 快乐数 {

    public static void main(String[] args) {
        int n = 19;

//        boolean happy = isHappy(19);
//        System.out.println(happy);

        System.out.println(199 % 10);
        System.out.println(199 / 10);
        System.out.println(5/10);
    }

    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static boolean isHappy1(int n) {
        String s = n + "";
        int sum = 0;
        HashSet<Integer> sets = new HashSet<>();
        while (true) {
            for (int i = 0; i < s.length(); i++) {
                String val = s.charAt(i) + "";
                Integer values = Integer.valueOf(val);
                sum = sum + values * values;
            }
            if (sum == 1) {
                break;
            }

            if (sets.contains(sum)) {
                return false;
            } else {
                sets.add(sum);
            }
            s = sum + "";
            sum = 0;
        }

        return true;
    }
}
