package com.example.coding.lec经典150.数组和字符串.简单.demo;

/**
 * @author liutc
 * @date 2024/5/15 08:47
 */

import java.util.Objects;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * <p>
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 */
public class 找出字符串中第一个匹配项的下标 {

    public static void main(String[] args) {
        String haystack = "leetcode";
        String needle = "leeto";
        int i = strStr(haystack, needle);
        System.out.println(i);
    }

    private static int strStr(String haystack, String needle) {
        int startIndex = 0;
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        for (int i = 0; i < haystackLength; i++) {
            if ((startIndex + needleLength) <= haystackLength) {
                if (haystack.substring(startIndex, (startIndex + needleLength)).equals(needle)) {
                    return startIndex;
                } else {
                    startIndex++;
                }
            }
        }

        return -1;
    }

}
