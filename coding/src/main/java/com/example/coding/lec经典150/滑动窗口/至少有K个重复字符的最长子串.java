package com.example.coding.lec经典150.滑动窗口;

import java.util.Arrays;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * 如果不存在这样的子字符串，则返回 0。
 * <p>
 * 示例 1：
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * <p>
 * 示例 2：
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * <p>
 * <p>
 * 提示：
 * 1 <= s.length <= 10的四次方
 * s 仅由小写英文字母组成
 * 1 <= k <= 10的五次方
 */
public class 至少有K个重复字符的最长子串 {

    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        int substring = longestSubstring(s, k);
        System.out.println(substring);
    }

    public static int longestSubstring(String s, int k) {
        int length = s.length();
        int[] counts = new int[256];
        int len = 0;
        for (int require = 1; require <= 26; require++) {
            //相当于不停复原
            Arrays.fill(counts, 0);

            for (int l = 0, r = 0, collect = 0, statisfy = 0; r < length; r++) {
                char c = s.charAt(r);
                counts[c]++;
                if (counts[c] == 1) {
                    collect++;
                }
                if (counts[c] == k) {
                    statisfy++;
                }

                while (collect > require) {
                    char cl = s.charAt(l);
                    if (counts[cl] == 1) {
                        collect--;
                    }
                    if (counts[cl] == k) {
                        statisfy--;
                    }
                    counts[cl]--;
                    l++;
                }

                if (statisfy == require) {
                    len = Math.max(len, r - l + 1);
                }
            }
        }

        return len;
    }
}
