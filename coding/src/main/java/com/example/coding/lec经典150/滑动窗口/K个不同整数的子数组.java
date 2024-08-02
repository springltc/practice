package com.example.coding.lec经典150.滑动窗口;

/**
 * 给定一个正整数数组 nums和一个整数 k，返回 nums 中 「好子数组」 的数目。
 * <p>
 * 如果 nums 的某个子数组中不同整数的个数恰好为 k，则称 nums 的这个连续、不一定不同的子数组为 「好子数组 」。
 * <p>
 * 例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。
 * 子数组 是数组的 连续 部分。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,1,2,3], k = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,1,3,4], k = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 10的四次方
 * 1 <= nums[i], k <= nums.length
 */
public class K个不同整数的子数组 {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 1;
        int distinct = subarraysWithKDistinct(nums, k);
        System.out.println(distinct);
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return sub(nums, k) - sub(nums, k - 1);
    }

    //l...r
    public static int sub(int[] nums, int k) {
        int n = nums.length;
        int[] counts = new int[20001];
        int aws = 0;

        for (int l = 0, r = 0, collect = 0; r < n; r++) {
            if (++counts[nums[r]] == 1) {
                collect++;
            }
            while (collect > k) {
                if (--counts[nums[l++]] == 0) {
                    collect--;
                }
            }
            aws = aws + r - l + 1;
        }

        return aws;
    }
}
