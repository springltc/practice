package com.example.coding.lec经典150.二分查找;

/**
 * @author liutc
 * @date 2025/1/7 16:28
 */
public class Demo {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        int[] ints = searchRange(nums, target);
        System.out.println(ints);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        if (length == 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        int start = 0;
        int end = length - 1;
        int first = -1;
        //找到等于target的起始位置
        while (end >= start) {
            int m = (start + end) / 2;
            if (nums[m] >= target) {
                end = m - 1;
                first = m;
            } else {
                start = m + 1;
            }
        }

        if (first == -1) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        int left = first;
        while (left < (length - 1) && nums[left + 1] == target) {
            left = left + 1;
        }

        if (first != left) {
            result[0] = first;
            result[1] = left;
        }

        return result;
    }
}
