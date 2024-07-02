package com.example.coding.lec经典150.哈希.demo;

/**
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 */

/**
 * 示例1:
 *
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 提示:
 *
 * 1 <= pattern.length <= 300
 * pattern 只包含小写英文字母
 * 1 <= s.length <= 3000
 * s 只包含小写英文字母和 ' '
 * s 不包含 任何前导或尾随对空格
 * s 中每个单词都被 单个空格 分隔
 */
public class 单词规律 {

    public static void main(String[] args) {
        String s = "dog cat cat dog";
        String pattern = "abba";
        boolean wordPattern = wordPattern(pattern, s);
        System.out.println(wordPattern);
    }

    private static boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Set<String> sets = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            String val = map.get(pattern.charAt(i));
            if (val != null) {
                if (!val.equals(split[i])) {
                    return false;
                }
            } else {
                map.put(pattern.charAt(i), split[i]);
                sets.add(split[i]);
            }
        }

        return sets.size() == map.size();
    }

}
