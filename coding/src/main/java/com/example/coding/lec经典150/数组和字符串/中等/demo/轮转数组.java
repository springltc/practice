package com.example.coding.lec经典150.数组和字符串.中等.demo;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */

/**
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class 轮转数组 {

    public static void main(String[] args) {
        //nums = [1,2,3,4,5,6,7], k = 3
        System.out.println((0 + 3) % 7);
        System.out.println((1 + 3) % 7);
        System.out.println((2 + 3) % 7);
        System.out.println("=============");
        System.out.println((4 + 3) % 7);
        System.out.println((5 + 3) % 7);
        System.out.println((6 + 3) % 7);

        //
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] newNums = new int[length];
        for (int i = 0; i < length; i++) {
            newNums[(i + k) % length] = nums[i];
        }
        for (int i = 0; i < newNums.length; i++) {
            nums[i] = newNums[i];
        }
    }
}

