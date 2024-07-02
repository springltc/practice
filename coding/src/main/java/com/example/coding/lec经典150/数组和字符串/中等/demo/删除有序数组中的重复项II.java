package com.example.coding.lec经典150.数组和字符串.中等.demo;

/**
 * @author liutc
 * @date 2024/5/21 09:31
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
 */

/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 */
public class 删除有序数组中的重复项II {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int i = removeDuplicates(nums);
        System.out.println(i);

        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }

    public static int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int repeatCount = 1;
            int val = nums[0];
            int sum = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == val && repeatCount < 2) {
                    nums[sum] = val;
                    repeatCount++;
                    sum++;
                } else if (nums[i] != val) {
                    nums[sum] = nums[i];
                    val = nums[i];
                    repeatCount = 1;
                    sum++;
                }
            }

            return sum;
    }
}
