package com.example.coding.lec经典150.数组和字符串.中等.demo;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * <p>
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 */
public class Z字形变换 {

    public static void main(String[] args) {
//        System.out.println(0 % 3);
//        System.out.println(1 % 3);
//        System.out.println(2 % 3);
//        System.out.println(3 % 3);


        String s = "PAYPALISHIRING";
        //PAHNAPLSIIGYIR
        String convert = convert(s, 3);
        System.out.println(convert);
    }

    private static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        HashMap<Integer, String> map = new HashMap<>();
        int index = 1;
        int operate = 1;
        for (int i = 0; i < s.length(); i++) {
            String val = map.get(index);
            if (val == null) {
                map.put(index, s.charAt(i) + "");
            } else {
                map.put(index, val + s.charAt(i));
            }


            if (index == numRows) {
                operate = -1;
            }
            if (index == 1) {
                operate = 1;
            }
            index = index + operate;
        }

        String rs = "";
        for (int i = 1; i <= numRows; i++) {
            rs = rs + map.getOrDefault(i, "");
        }

        return rs;
    }

}
