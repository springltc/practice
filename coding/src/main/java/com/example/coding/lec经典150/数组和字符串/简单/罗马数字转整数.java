package com.example.coding.lec经典150.数组和字符串.简单;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 示例 1:
 * <p>
 * 输入: s = "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: s = "IV"
 * 输出: 4
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "IX"
 * 输出: 9
 * <p>
 * 示例 4:
 * <p>
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * 示例 5:
 * <p>
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class 罗马数字转整数 {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt3(String s) {
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += which(s.charAt(i));
        }
        return result;
    }

    public static int which(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case 'a':
                return 4;
            case 'b':
                return 9;
            case 'c':
                return 40;
            case 'd':
                return 90;
            case 'e':
                return 400;
            case 'f':
                return 900;
        }
        return 0;
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> addMap = new HashMap<>();
        /**
         * I             1
         * V             5
         * X             10
         * L             50
         * C             100
         * D             500
         * M             1000
         */
        addMap.put('I', 1);
        addMap.put('V', 5);
        addMap.put('X', 10);
        addMap.put('L', 50);
        addMap.put('C', 100);
        addMap.put('D', 500);
        addMap.put('M', 1000);

        HashMap<Character, List<Character>> subMap = new HashMap<>();
        /**
         * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
         * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
         * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900
         */
        List<Character> list1 = new ArrayList<>();
        list1.add('V');
        list1.add('X');
        subMap.put('I', list1);

        List<Character> list2 = new ArrayList<>();
        list2.add('L');
        list2.add('C');
        subMap.put('X', list2);

        List<Character> list3 = new ArrayList<>();
        list3.add('D');
        list3.add('M');
        subMap.put('C', list3);

        if (s.length() == 1) {
            return addMap.get(s.charAt(0));
        }

        /**
         *  * 输入: s = "MCMXCIV"
         *  * 输出: 1994
         *  * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
         */
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (i + 1 < s.length()) {
                List<Character> characters = subMap.get(charAt);
                if (characters != null) {
                    if (subMap.get(s.charAt(i)).contains(s.charAt(i + 1))) {
                        sum = sum + (addMap.get(s.charAt(i + 1)) - addMap.get(s.charAt(i)));
                        i++;
                        continue;
                    }
                }
            }
            sum = sum + addMap.get(charAt);
        }

        return sum;
    }

    public static int romanToInt2(String s) {
        HashMap<Character, Integer> addMap = new HashMap<>();
        addMap.put('I', 1);
        addMap.put('V', 5);
        addMap.put('X', 10);
        addMap.put('L', 50);
        addMap.put('C', 100);
        addMap.put('D', 500);
        addMap.put('M', 1000);

        HashMap<Character, List<Character>> subMap = new HashMap<>();
        List<Character> list1 = new ArrayList<>();
        list1.add('V');
        list1.add('X');
        subMap.put('I', list1);

        List<Character> list2 = new ArrayList<>();
        list2.add('L');
        list2.add('C');
        subMap.put('X', list2);

        List<Character> list3 = new ArrayList<>();
        list3.add('D');
        list3.add('M');
        subMap.put('C', list3);

        if (s.length() == 1) {
            return addMap.get(s.charAt(0));
        }

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (i + 1 < s.length()) {
                List<Character> characters = subMap.get(charAt);
                if (characters != null) {
                    char charAt1 = s.charAt(i + 1);
                    if (subMap.get(charAt).contains(charAt1)) {
                        sum = sum + (addMap.get(charAt1) - addMap.get(charAt));
                        i++;
                        continue;
                    }
                }
            }
            sum = sum + addMap.get(charAt);
        }

        return sum;
    }
}
