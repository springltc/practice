package com.example.coding.lec经典150.双指针;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liutc
 * @date 2024/7/5 14:12
 */
public class 两数之和 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null) {
                return new int[]{i, index};
            } else {
                map.put(target - nums[i], i);
            }
        }

        return new int[]{};
    }
}
