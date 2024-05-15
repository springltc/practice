package com.example.coding.lec.数组和字符串.简单;


/**
 * * 编写一个函数来查找字符串数组中的最长公共前缀。
 *  * <p>
 *  * 如果不存在公共前缀，返回空字符串 ""。
 *  * <p>
 */

/**
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀
 */

/**
 * 备注:是前缀欧
 */
public class 最长公共前缀 {

    public static void main(String[] args) {
        String[] s = {"flower", "flow", "flight"};
        String s1 = longestCommonPrefix(s);
        System.out.println(s1);
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        int min = Math.min(str1.length(), str2.length());
        for (int i = 0; i < min; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, min);
    }


}
