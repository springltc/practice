package com.example.coding.demo;

/**
 * @author liutc
 * @date 2025/1/13 16:32
 */
public class 双指针D {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int search = search(nums,0);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int length = nums.length;

        int start = 0;
        int end = length - 1;
        int startVal = nums[0];
        while (end >= start) {
            int m = (start + end) / 2;
            int val = nums[m];
            if (target >= startVal) {
                if (nums[m - 1] < nums[m]) {
                    if (val > target) {
                        end = m - 1;
                    } else if (val < target) {
                        start = m + 1;
                    } else {
                        return m;
                    }
                } else {
                    end = m - 1;
                }
            } else {
                if (nums[m - 1] > nums[m]) {
                    if (val > target) {
                        start = m + 1;
                    } else if (val < target) {
                        end = m - 1;
                    } else {
                        return m;
                    }
                } else {
                    start = m + 1;
                }
            }
        }

        return -1;
    }
}
