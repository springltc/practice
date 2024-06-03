package com.example.coding.lec热题100.简单.滑动窗口;

/**
 * @author liutc
 * @date 2024/6/3 14:40
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 */

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 */

import java.lang.reflect.AnnotatedWildcardType;
import java.util.HashSet;
import java.util.Set;

/**
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class 无重复字符的最长子串 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int step = 0;
        int ans = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            //abc abcbb
            //a bca bcbb
            //ab cab cbb
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }

            while (step < length && !set.contains(s.charAt(step))) {
                set.add(s.charAt(step));
                ++step;
            }
            ans = Math.max(ans, step - i);
        }

        return ans;
    }
}
