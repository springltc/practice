package com.example.coding.lec经典150.二分查找.基础;

/**
 * @author liutc
 * @date 2024/7/19 11:29
 */
public class 有序数组中是否存在一个数字 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        //l=0 r=3
        //m =(0+3)/2 = 3/2 =1
        //3<8 -> l = m + 1 = 1 + 1 = 2
        //m =(2+3)/2 = 2
        //5<8 -> l = m + 1 = 2 + 1 = 3
        //m =(3+3)/2 = 3
        //6<8 -> l = m + 1 = 3 + 1 = 4
        //l>r 跳出循环

        //l=0 r=1
        //m = 1/2 = 0
        //l=1 或 r = 0 如果l=1则来到1位置 如果r=0也来到1位置 然后l不能再加了 r也不能再减了
        int target = 8;
        boolean exist = exist(nums, target);
        System.out.println(exist);
    }

    public static boolean exist(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int l = 0, r = nums.length - 1, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                return true;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
