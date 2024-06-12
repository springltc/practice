package com.example.coding.lec热题100.简单.动态规划;

/**
 * @author liutc
 * @date 2024/6/12 17:16
 * <p>
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 *
 * 提示:
 *
 * 1 <= numRows <= 30
 */
public class 杨辉三角 {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> c = new ArrayList<>(numRows); // 预分配空间
            c.add(Arrays.asList(1));
            for (int i = 1; i < numRows; i++) {
                List<Integer> row = new ArrayList<>(i + 1); // 预分配空间
                row.add(1);
                for (int j = 1; j < i; j++) {
                    // 左上方的数 + 正上方的数
                    row.add(c.get(i - 1).get(j - 1) + c.get(i - 1).get(j));
                }
                row.add(1);
                c.add(row);
            }
            return c;
        }
    }

}
