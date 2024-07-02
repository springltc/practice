package com.example.coding.lec经典150.数组和字符串.简单.demo;

/**
 * @author liutc
 * @date 2024/5/13 10:27
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * <p>
 * ------>这里的"非递减顺序"指的就是递增
 */
public class 合并两个有序数组 {

    /**
     * 非递减顺序 排列的整数数组 nums1 和 nums2->升序
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge2(nums1, m, nums2, n);
        System.out.println(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = 0;
        int nums2Index = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (nums1Index >= m) {
                list.add(nums2[nums2Index]);
                nums2Index++;
                continue;
            }
            if (nums2Index >= n) {
                list.add(nums1[nums1Index]);
                nums1Index++;
                continue;
            }

            if (nums1[nums1Index] > nums2[nums2Index]) {
                list.add(nums2[nums2Index]);
                nums2Index++;
            } else {
                list.add(nums1[nums1Index]);
                nums1Index++;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            nums1[i] = list.get(i);
        }
    }
}
