package com.example.coding.lec经典150.堆.demo;

import java.util.Arrays;

//测试链接 : https://leetcode.cn/problems/sort-an-array/
public class 堆排序_向下调整大根堆 {

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        sortArray(nums);
        String s = Arrays.toString(nums);
        System.out.println(s);
    }

    // 从顶到底建立大根堆，O(n * logn)
    // 依次弹出堆内最大值并排好序，O(n * logn)
    // 整体时间复杂度O(n * logn)
    public static int[] sortArray(int[] nums) {
        int size = nums.length;
        for (int j = size - 1; j >= 0; j--) {
            int i = j;
            int l = i * 2 + 1;
            while (l < size) {
                int best = l + 1 < size && nums[l + 1] > nums[l] ? l + 1 : l;
                best = nums[best] > nums[i] ? best : i;
                if (best == i) {
                    break;
                }
                swap(nums, i, best);
                i = best;
                l = i * 2 + 1;
            }
        }

        while (size > 1) {
            swap(nums, 0, --size);

            int i = 0;
            int l = i * 2 + 1;
            while (l < size) {
                int best = l + 1 < size && nums[l + 1] > nums[l] ? l + 1 : l;
                best = nums[best] > nums[i] ? best : i;
                if (best == i) {
                    break;
                }
                swap(nums, i, best);
                i = best;
                l = i * 2 + 1;
            }
        }

        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

}
