package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:78. 子集 https://leetcode-cn.com/problems/subsets/
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 * @author: huanghongbo
 * @date: 2021-10-18 16:19
 **/
public class question_0078 {


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private static void subsets(int[] nums, List<List<Integer>> result, ArrayList<Integer> list, int index) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 迭代
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //初始[[]]
        //1: [[],[1]]
        //2: [[],[1],[1,2],[2]]
        //3: [[],[1],[1,2],[2],[3],[1,3],[1,2,3],[2,3]]
        list.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(list.get(j));
                temp.add(nums[i]);
                list.add(new ArrayList<>(temp));
            }
        }
        return list;
    }


    public static void main(String[] args) {
        System.err.println(subsets2(new int[]{1, 2, 3}));
    }
}
