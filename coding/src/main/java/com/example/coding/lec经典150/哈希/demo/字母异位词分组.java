package com.example.coding.lec经典150.哈希.demo;

/**
 * @author liutc
 * @date 2024/2/6 13:20
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */

/**
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class 字母异位词分组 {
    public static void main(String[] args) {
//        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String strs[] = {"", ""};
        List<List<String>> lists = groupAnagrams2(strs);
        System.out.println(lists);
    }

    private static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            List<String> stringList = map.getOrDefault(sortStr, new ArrayList<>());
            stringList.add(str);
            map.put(sortStr, stringList);
        }

        return new ArrayList<>(map.values());
    }


    /**
     * 实现的太复杂了
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if (strs.length == 0) {
            list.add(new ArrayList<>());
            return list;
        }
        if (strs.length == 1) {
            list.add(Arrays.asList(strs[0]));
            return list;
        }

        HashMap<String, int[]> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            int[] ints = new int[26];
            for (char c : chars) {
                ints[c - 'a']++;
            }
            map.put(str, ints);
        }

        Set<Integer> indexSet = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            List<String> stringList = new ArrayList<>();
            if (!indexSet.contains(i)) {
                stringList.add(str);
            }
            indexSet.add(i);
            for (int j = 1; j < strs.length; j++) {
                String str2 = strs[j];
                if (indexSet.contains(j)) {
                    continue;
                }

                if (str.length() == str2.length()) {
                    int[] ints = map.get(str);
                    int[] ints2 = map.get(str2);
                    int count = 0;
                    for (int i1 = 0; i1 < ints.length; i1++) {
                        if (ints[i1] != ints2[i1]) {
                            count++;
                            break;
                        }
                    }
                    if (count == 0) {
                        indexSet.add(j);
                        stringList.add(str2);
                    }
                }
            }

            if (!stringList.isEmpty()) {
                list.add(stringList);
            }
        }

        return list;
    }
}

