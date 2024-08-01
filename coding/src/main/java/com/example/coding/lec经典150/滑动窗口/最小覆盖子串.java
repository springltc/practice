package com.example.coding.lec经典150.滑动窗口;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * <p>
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 */
//https://leetcode.cn/problems/minimum-window-substring/description/
public class 最小覆盖子串 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        String window = minWindow(s, t);
        System.out.println(window);
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] ints = new int[256];
        for (int i = 0; i < tc.length; i++) {
            ints[tc[i]]--;
        }

        int len = Integer.MAX_VALUE;
        int start = 0;
        for (int l = 0, r = 0, sum = t.length(); r < s.length(); r++) {
            if (ints[sc[r]]++ < 0) {
                sum--;
            }
            if (sum == 0) {
                while (ints[sc[l]] > 0) {
                    ints[sc[l++]]--;
                }
                //只有len最小的时候才更新
                if (r - l + 1 < len) {
                    start = l;
                    len = r - l + 1;
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
