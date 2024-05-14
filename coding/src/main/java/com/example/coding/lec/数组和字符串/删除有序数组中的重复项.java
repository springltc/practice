package com.example.coding.lec.数组和字符串;

/**
 * @author liutc
 * @date 2024/5/13 10:54
 */

/**
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * <p>
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * <p>
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素
 */
public class 删除有序数组中的重复项 {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length = removeDuplicates(nums);

        for (int j = 0; j < length; j++) {
            System.out.println(nums[j]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int count = 0;
        int val = nums[0];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                nums[count] = val;
                count++;
            }

            if (i + 1 < length && nums[i + 1] != val) {
                val = nums[i + 1];
                nums[count] = val;
                count++;
            }
        }

        return count;
    }


}
