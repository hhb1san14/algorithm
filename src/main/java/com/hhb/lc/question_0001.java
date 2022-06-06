package com.hhb.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hhb
 * @date 2022/6/6
 * @description
 */
public class question_0001 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{i, map.get(temp)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        System.err.println(twoSum(arr, 9));
    }

}
