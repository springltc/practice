package com.example.coding.lec经典150.位运算.简单;

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 示例 1：
 *
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 *
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 */
public class 二进制求和 {

    public static void main(String[] args) {
        System.out.println('1' - '0');
        String a = "1010", b = "1011";
        String binary = addBinary(a, b);
        System.out.println(binary);
    }

    //1101
    //  10
    public static String addBinary(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        int maxLength = Math.max(lengthA, lengthB);

        List<Integer> list = new ArrayList<>();
        int step = 0;
        for (int i = 0; i < maxLength; i++) {
            int aVal = i > lengthA - 1 ? 0 : a.charAt(lengthA - 1 - i) - '0';
            int bVal = i > lengthB - 1 ? 0 : b.charAt(lengthB - 1 - i) - '0';
            int sum = aVal + bVal + step;
            list.add(sum % 2);
            step = sum / 2;
        }
        if (step > 0) {
            list.add(step);
        }
        StringBuilder res = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            res.append(list.get(i));
        }

        return res.toString();
    }
}
