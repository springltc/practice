package com.example.coding.lec热题100.简单.双指针;

/**
 * @author liutc
 * @date 2024/2/6 17:20
 */

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 */
public class 移动零 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    /**
     * 双指针解法
     */
    public static void moveZeroes(int[] nums) {
        // int[] nums = {0, 1, 0, 3, 12};
        // int[] nums = {1, 0, 0, 3, 12};
        // int[] nums = {1, 0, 0, 3, 12};
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value != 0) {
                //交换
                int tem = nums[left];
                nums[left++] = value;
                nums[i] = tem;
            }
        }
    }

    public static void moveZeroesSimple(int[] nums) {
        //保持非零元素的相对顺序。
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count] = nums[i];
                count++;
            }
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 双指针解法
     */
    public static void moveZeroes1(int[] nums) {
        // int[] nums = {0, 1, 0, 3, 12};
        //实现
        // int[] nums = {1, 0, 0, 3, 12};
        // int[] nums = {1, 3, 0, 0, 12};
        // int[] nums = {1, 3, 12, 0, 0};
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
