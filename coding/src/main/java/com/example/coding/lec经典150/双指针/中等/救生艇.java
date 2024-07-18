package com.example.coding.lec经典150.双指针.中等;

/**
 * 给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
 * <p>
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * <p>
 * 返回 承载所有人所需的最小船数 。
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 示例 1：
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * <p>
 * 示例 2：
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * <p>
 * 示例 3：
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 */
//https://leetcode.cn/problems/boats-to-save-people/submissions/547644735/
public class 救生艇 {

    public static void main(String[] args) {
        int[] people = {3, 5, 3, 4};
        int limit = 4;
        int rescueBoats = numRescueBoats2(people, limit);
        System.out.println(rescueBoats);
    }

    public static int numRescueBoats2(int[] people, int limit) {
        Arrays.sort(people);

        int count = 0;
        int start = 0;
        int end = people.length - 1;
        while (start <= end) {
            int sum = people[start] + people[end];
//            int sum2 = start == end ? people[start] : people[start] + people[end];
            if (sum <= limit) {
                start++;
                end--;
            } else {
                end--;
            }
            count++;
        }

        return count;
    }

}
