package com.example.coding.lec经典150.哈希.demo;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，
 * 相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 示例 1:
 * <p>
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s = "paper", t = "title"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s 和 t 由任意有效的 ASCII 字符组成
 */
public class 同构字符串 {

    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        boolean isomorphic = isIsomorphic(s, t);
        System.out.println(isomorphic);
    }

    /**
     * 可能s的单词一直不一样 导致一直put 然后最终返回了true
     */
    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Set<Character> sets = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = map.get(s.charAt(i));
            if (character != null) {
                if (t.charAt(i) != character) {
                    return false;
                }
            } else {
                map.put(s.charAt(i), t.charAt(i));
                sets.add(t.charAt(i));
            }
        }

        return sets.size() == map.size();
    }

}
