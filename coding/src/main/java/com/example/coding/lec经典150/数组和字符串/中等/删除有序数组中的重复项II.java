package com.example.coding.lec经典150.数组和字符串.中等;

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
        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        int count = 0;
        int start = nums[0];
        int repeat = 0;
        for (int i = 0; i < length; i++) {
            if (repeat >= 2 && nums[i] == start) {
                continue;
            }

            if (nums[i] != start){
                start = nums[i];
                repeat = 0;
            }

            nums[count] = nums[i];
            count++;
            repeat++;
        }

        return count;
    }
}
