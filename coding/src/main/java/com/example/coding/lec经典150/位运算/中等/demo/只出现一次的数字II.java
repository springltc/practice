package com.example.coding.lec经典150.位运算.中等.demo;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 */

/**
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 */
public class 只出现一次的数字II {

    /**
     * 1 << 4 的结果是 16，表示将 1 的二进制表示左移 4 位得到 10000，即十进制的 16。
     * <p>
     * 4 << 1 的结果是 8，表示将 4 的二进制表示左移 1 位得到 1000，即十进制的 8。
     * <p>
     * 因此，这两个表达式得到的结果分别是 16 和 8，它们的区别在于左移的位数不同。
     */
    public static void main(String[] args) {
//        System.out.println(0 % 3);
        int[] nums = {2, 2, 3, 2};

//        System.out.println();
//        for (int i = 0; i < 32; i++) {
//            System.out.println(1 << i);
//        }

        int number = singleNumber(nums);
        System.out.println(number);
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum = sum + ((num >> i) & 1);
            }
            if (sum % 3 != 0) {
                ans = ans | (1 << i);
            }
        }

        return ans;
    }
}
