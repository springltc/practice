package com.example.coding.lec经典150.滑动窗口;

/**
 * @author liutc
 * @date 2024/2/7 13:41
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String s = "abba";
        int i = method1(s);
        System.out.println(i);
    }

    /**
     * abcabcbb
     *
     * @param s
     * @return
     */
    public static int method1(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0, len = s.length();
        for (int j = 0; j < len; j++) {
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            }
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }

    public static int method2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;
    }
}
