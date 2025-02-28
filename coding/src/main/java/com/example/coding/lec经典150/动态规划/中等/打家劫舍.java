package com.example.coding.lec经典150.动态规划.中等;

/**
 * @author liutc
 * @date 2025/1/9 11:06
 */
public class 打家劫舍 {

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        // 动态规划
        int length = nums.length;
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[length - 1];
    }
}
