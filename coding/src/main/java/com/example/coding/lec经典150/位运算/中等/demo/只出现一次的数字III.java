package com.example.coding.lec经典150.位运算.中等.demo;

/**
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 */

/**
 * 示例 1：
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * <p>
 * 示例 2：
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * <p>
 * 示例 3：
 * 输入：nums = [0,1]
 * 输出：[1,0]
 */
public class 只出现一次的数字III {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 1, 3, 2, 5};
//        int[] number = singleNumber(nums);
//        System.out.println(number);
    }

    public static int[] singleNumber(int[] nums) {
        int r1 = 0; //a^b
        for (int i = 0; i < nums.length; i++) {
            r1 = r1 ^ nums[i];
        }

        //提出最右侧的1
        int y = r1 & (-r1);

        int r2 = 0;
        for (int num : nums) {
            if ((num & y) == 0) {
                r2 = r2 ^ num;
            }
        }

        return new int[]{r2, r1 ^ r2};
    }

}
