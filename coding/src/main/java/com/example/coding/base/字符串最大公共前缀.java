package com.example.coding.base;

import jdk.jfr.internal.tool.Main;

/**
 * @author liutc
 * @date 2025/1/5 18:38
 */
public class 字符串最大公共前缀 {

    public static void main(String[] args) {
        System.out.println("".substring(0,0));

        String[] strs = {"flower", "flow", "flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        String strFirst = strs[0];
        if ("".equals(strFirst)) {
            return "";
        }

        int maxLength = strFirst.length();
        int end = 1;
        String prefix = "";
        while (end <= maxLength) {
            String sub = strFirst.substring(0, end);

            for (int i = 1; i < length; i++) {
                String val = strs[i];
                if (val.length() < end) {
                    return prefix;
                }

                String prefix2 = val.substring(0, end);
                if (!prefix2.equals(sub)) {
                    return prefix;
                }
            }

            prefix = sub;
            end++;
        }

        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        int length = strs.length;
        int start = 0;
        String strStart = strs[0];
        String max = "";
        int end = start + 1;
        while (start <= strStart.length()) {
            String sub = strStart.substring(start, end);
            int count = 0;
            for (int i = 1; i < length; i++) {
                String str = strs[i];
                if (str.contains(sub)) {
                    count++;
                } else {
                    start++;
                    end = start + 1;
                }
            }
            if (count == (length - 1)) {
                end++;
                if (max.length() < sub.length()) {
                    max = sub;
                }
            }
            if (end > strStart.length()) {
                break;
            }
        }

        return max;
    }
}
