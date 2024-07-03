package com.example.coding.lec经典150.哈希;


/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class 有效的字母异位词 {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char val = chars[i];
            Integer count = map.get(val);
            if (count == null) {
                map.put(val, 1);
            } else {
                map.put(val, count + 1);
            }
        }

        char[] charArray = t.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char val = charArray[i];
            Integer count = map.get(val);
            if (count == null || count == 0) {
                return false;
            } else {
                map.put(val, --count);
            }
        }

        return true;
    }
}
