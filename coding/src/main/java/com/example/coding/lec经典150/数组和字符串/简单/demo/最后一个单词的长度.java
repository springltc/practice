package com.example.coding.lec经典150.数组和字符串.简单.demo;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串
 */

import java.util.Objects;

/**
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为 5。
 * 示例 2：
 * <p>
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为 4。
 * 示例 3：
 * <p>
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为 6 的“joyboy”。
 */
public class 最后一个单词的长度 {

    public static void main(String[] args) {
        String str = "   fly me   to   the moon  ";
        String[] s1 = str.split(" ");

        String s = "luffy is still joyboy";
        int i = lengthOfLastWord(s);
        System.out.println(i);
    }

    private static int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        int length = 0;
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            if (!Objects.equals(str, "")) {
                length = str.length();
            }
        }
        return length;
    }

}
