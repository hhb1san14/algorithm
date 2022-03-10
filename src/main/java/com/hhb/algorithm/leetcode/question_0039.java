package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:39. 组合总和 https://leetcode-cn.com/problems/combination-sum/
 * <p>
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 * <p>
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 * 示例 4：
 * <p>
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 * 示例 5：
 * <p>
 * 输入: candidates = [1], target = 2
 * 输出: [[1,1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * @author: huanghongbo
 * @date: 2021-09-09 10:30
 **/
public class question_0039 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, list, target, tempList, 0);
        return list;

    }

    private static void combinationSum2(int[] candidates, List<List<Integer>> list, int target, List<Integer> tempList, int depth) {
        if (depth == candidates.length) {
            return;
        }
        if (target == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = depth; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                tempList.add(candidates[i]);
                combinationSum2(candidates, list, target - candidates[i], tempList, depth ++);
                tempList.remove(tempList.size() - 1);
            }


        }


    }


    /**
     * 看的答案
     * @param candidates
     * @param list
     * @param target
     * @param tempList
     * @param index
     */
//    private static void combinationSum(int[] candidates, List<List<Integer>> list, int target, List<Integer> tempList, int index) {
//        if (candidates.length == index) {
//            return;
//        }
//        if (target == 0) {
//            list.add(tempList);
//            return;
//        }
//        combinationSum(candidates, list, target, tempList, index + 1);
//        if (target - candidates[index] >= 0) {
//            tempList.add(candidates[index]);
//            combinationSum(candidates, list, target - candidates[index], tempList, index);
//            tempList.remove(tempList.size() - 1);
//        }
//
//    }

    /**
     * 自己写的
     * 递归之前：[2]  target ：7  i: 0 index: 0
     * 递归之前：[2, 2]  target ：5  i: 0 index: 0
     * 递归之前：[2, 2, 2]  target ：3  i: 0 index: 0
     * 递归之后：[2, 2]  target ：3  i: 0 index: 1
     * 递归之前：[2, 2, 3]  target ：3  i: 1 index: 1
     * 递归之后：[2, 2]  target ：3  i: 1 index: 2
     * 递归之后：[2]  target ：5  i: 0 index: 1
     * 递归之前：[2, 3]  target ：5  i: 1 index: 1
     * 递归之后：[2]  target ：5  i: 1 index: 2
     * 递归之后：[]  target ：7  i: 0 index: 1
     * 递归之前：[3]  target ：7  i: 1 index: 1
     * 递归之前：[3, 3]  target ：4  i: 1 index: 1
     * 递归之后：[3]  target ：4  i: 1 index: 2
     * 递归之后：[]  target ：7  i: 1 index: 2
     * 递归之前：[6]  target ：7  i: 2 index: 2
     * 递归之后：[]  target ：7  i: 2 index: 3
     * 递归之前：[7]  target ：7  i: 3 index: 3
     * 递归之后：[]  target ：7  i: 3 index: 4
     *
     * @param candidates
     * @param list
     * @param target
     * @param tempList
     * @param index
     */
    private static void combinationSum(int[] candidates, List<List<Integer>> list, int target, List<Integer> tempList, int index) {
        // 当数组的长度和使用的长度相同的时候，直接返回
        if (candidates.length == index) {
            return;
        }
        // 如果目标值为0，说明找到了，直接添加到结果里面
        if (target == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        // i = index,是为了保证，从当前位置，向后遍历
        for (int i = index; i < candidates.length; i++) {
            // 如果目标值 - 当前值  >= 0,该值符合，
            if (target - candidates[i] >= 0) {
                // 所以添加到临时集合中
                tempList.add(candidates[i]);
                System.err.println("递归之前：" + tempList + "  target ：" + target + "  i: " + i + " index: " + index);
                //将当前期添加到集合中后，目标值减小，
                combinationSum(candidates, list, target - candidates[i], tempList, index++);
                // 剪枝，移除最后一个值
                tempList.remove(tempList.size() - 1);
                System.err.println("递归之后：" + tempList + "  target ：" + target + "  i: " + i + " index: " + index);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
