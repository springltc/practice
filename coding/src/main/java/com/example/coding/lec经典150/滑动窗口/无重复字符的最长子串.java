package com.example.coding.lec经典150.滑动窗口;

import java.util.Arrays;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 10的4次方
 * s 由英文字母、数字、符号和空格组成
 */
//https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String s = "dvdf";
        //pwwkew
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }

    //pweops
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int aws = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            l = Math.max(l, last[chars[r]] + 1);
            aws = Math.max(aws, r - l + 1);
            last[chars[r]] = r;
        }

        return aws;
    }
}
