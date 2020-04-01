package com.hhb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huanghongbo
 * @Date: 2020-03-30 15:52
 * @Description: 两数之和  https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例: 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class question_0001 {

    /**
     * 双层for循环,时间复杂度O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int param1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (param1 + nums[j] == target) {
                    array[0] = i;
                    array[1] = j;
                    return array;
                }
            }
        }
        return array;
    }

    /**
     * 官方：两遍哈希表 时间复杂度:O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result) && map.get(result) != i) {
                return new int[]{i, map.get(result)};
            }
        }
        throw new IllegalArgumentException("");
    }

    /**
     * 官方：一遍哈希表 时间复杂度:O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result) && map.get(result) != i) {
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("");
    }



    public static void main(String[] args) {
        int[] array = {3, 2, 4};
        int[] ints = twoSum2(array, 6);
        System.err.println(ints[0] + "====" + ints[1]);
    }

}
