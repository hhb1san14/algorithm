package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 46. 全排列 https://leetcode-cn.com/problems/permutations/
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * @author: huanghongbo
 * @date: 2021-09-10 09:39
 **/
public class question_0046 {

    public static void main(String[] args) {
        System.err.println(permute2(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute2(nums, list, new ArrayList<>());
        return list;
    }


    public static void permute2(int[] nums, List<List<Integer>> list, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            permute2(nums, list, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        permute(list, tempList, nums, 0);
        return list;
    }

    public static void permute(List<List<Integer>> list, List<Integer> tempList, int[] nums, int index) {
        if (index == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            System.err.println("递归之前：" + tempList + "i: " + i + " index: " + index);
            permute(list, tempList, nums, index + 1);
            tempList.remove(tempList.size() - 1);
            System.err.println("递归之后：" + tempList + "i: " + i + " index: " + index);

        }
    }

//    public static void main(String[] args) {
//        permute(new int[]{1, 2, 3});
//    }


}
