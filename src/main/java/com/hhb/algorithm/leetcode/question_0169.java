package com.hhb.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 169. 多数元素 https://leetcode-cn.com/problems/majority-element/
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 * <p>
 * 进阶：
 * <p>
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * @author: huanghongbo
 * @date: 2021-07-29 18:19
 **/
public class question_0169 {

    public int majorityElement(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            if (map.get(nums[i]) * 2 > nums.length) {
                result = nums[i];
                break;
            }
        }
        return result;
    }

    /**
     * O(logN)
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement3(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.getOrDefault(nums[i], 0) +1;
            if(value > nums.length / 2){
                result =  nums[i];
                break;
            }
            map.put(nums[i], value );
        }
        return result;
    }
}
