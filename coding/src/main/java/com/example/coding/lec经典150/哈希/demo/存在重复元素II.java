package com.example.coding.lec经典150.哈希.demo;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 */
public class 存在重复元素II {

    public static void main(String[] args) {
        //nums[i] == nums[j] 且 abs(i - j) <= k
        int[] nums = {1,2,3,1,2,3};
        int k = 1;
        boolean duplicate = containsNearbyDuplicate(nums, k);
        System.out.println(duplicate);
    }

    /**
     * 注意是<= ,只能不停的更换下标
     * 如果是大于等于则保存第一个数据的小标就行
     *
     * @param nums
     * @param k
     * @return
     */
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null) {
                if ((i - index) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }

        }

        return false;
    }

}
