package com.example.coding.lec经典150.数学;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 */
//https://leetcode.cn/problems/plus-one/?envType=study-plan-v2&envId=top-interview-150
public class 加一 {

    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9};
        int[] ints = plusOne(digits);
        System.out.println(ints);
    }

    public static int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int step = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = step + digits[i];
            if (i == (digits.length - 1)) {
                val = val + +1;
            }
            list.add(val % 10);
            step = val / 10;
        }
        if (step > 0) {
            list.add(1);
        }

        int[] res = new int[list.size()];
        int count = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            res[count] = list.get(i);
            count++;
        }
        return res;
    }
}
