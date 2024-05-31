package com.example.coding.lec热题100.简单.哈希;


/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class 字母异位词分组 {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

        List<List<String>> lists = groupAnagrams(strs);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            List<List<String>> list = new ArrayList<>();

            List<String> list1 = new ArrayList<>();
            list1.add(strs[0]);
            list.add(list1);

            return list;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String sort = new String(chars);
            List<String> list = map.get(sort);
            if (list == null) {
                List<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                map.put(sort, arrayList);
            } else {
                list.add(str);
            }
        }

        return new ArrayList<>(map.values());
    }
}
