package com.example.coding.lec经典150.双指针.中等;

/**
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * <p>
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * <p>
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * <p>
 * 注意：所有供暖器 heaters 都遵循你的半径标准，加热的半径也一样
 */

import jdk.nashorn.internal.runtime.FindProperty;

import java.util.Arrays;

/**
 * 示例 1:
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置 2 上有一个供暖器。如果我们将加热半径设为 1，那么所有房屋就都能得到供暖。
 * <p>
 * 示例 2:
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置 1, 4 上有两个供暖器。我们需要将加热半径设为 1，这样所有房屋就都能得到供暖。
 * <p>
 * 示例 3：
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 */
public class 供暖器 {

    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 4}, heaters = {1, 4};
        int radius = findRadius(houses, heaters);
        System.out.println(radius);
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int aws = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            while (!best(houses, heaters, i, j)) {
                j++;
            }
            aws = Math.max(aws, Math.abs(houses[i] - heaters[j]));
        }

        return aws;
    }

    private static boolean best(int[] houses, int[] heaters, int i, int j) {
        return j == heaters.length - 1 || Math.abs(houses[i] - heaters[j]) < Math.abs(houses[i] - heaters[j + 1]);
    }
}
