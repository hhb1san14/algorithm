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
public class question_0078_not_understand {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(result, new ArrayList<Integer>(), 0, nums);
        return result;
    }

    private static void subsets(List<List<Integer>> result, ArrayList<Integer> temp, int index, int[] nums) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            subsets(result, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }

    //结果集合
    static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> subsets2(int[] nums) {
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack2(nums, 0, track);
        return res;
    }

    //路径：记录到track中
    //选择：nums中索引从start往后（包括start）的元素
    //终止条件：start走到nums尾部
    public static void backtrack2(int[] nums, int start, LinkedList<Integer> track) {
        res.add(new LinkedList(track));
        //i从start开始
        for (int i = start; i < nums.length; i++) {
            //做出选择
            track.add(nums[i]);
            //到下一层决策树
            backtrack2(nums, i + 1, track);
            //撤回选择
            track.removeLast();
        }
    }

}
