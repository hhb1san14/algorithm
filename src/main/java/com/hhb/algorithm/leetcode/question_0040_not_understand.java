package com.hhb.algorithm.leetcode;

import java.util.*;

/**
 * @description:40. 组合总和 II https://leetcode-cn.com/problems/combination-sum-ii/
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。 
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * @author: huanghongbo
 * @date: 2021-09-28 16:49
 **/
public class question_0040_not_understand {

    private static Map<String, Boolean> map = new HashMap<>();

    //剪枝的方式，但是当前方式超时
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(list, tempList, candidates, target, 0);
        return list;
    }

    public static void combinationSum2(List<List<Integer>> list, List<Integer> tempList, List<Integer> indexList, int[] candidates, int target, int index, StringBuilder sb) {
        if (target == 0) {
            if (!map.containsKey(sb.toString())) {
                list.add(new ArrayList<>(tempList));
                map.put(sb.toString(), true);
                return;
            }
        }
        if (index == candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                tempList.add(candidates[i]);
                indexList.add(String.valueOf(candidates[i]).length());
                sb.append(candidates[i]);
                combinationSum2(list, tempList, indexList, candidates, target - candidates[i], i + 1, sb);
                System.err.println("start:" + (sb.toString().length() - indexList.get(tempList.size() - 1)) + "end:" + sb.toString().length());
                sb.delete(sb.toString().length() - indexList.get(tempList.size() - 1), sb.toString().length());
                indexList.remove(indexList.size() - 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void combinationSum2(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int target, int index) {
        if (target == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                // 就这段没懂，if判断
                if (i - 1 >= index && candidates[i - 1] == candidates[i]) { // 当前选项和左邻选项一样，跳过
                    continue;
                }
                tempList.add(candidates[i]);
                combinationSum2(list, tempList, candidates, target - candidates[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static boolean isSame(List<Integer> list1, List<Integer> list2) {
        return !(list1.containsAll(list2) && list2.containsAll(list1));
    }


    public static void main(String[] args) {
        //[14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12]
        //27
//        combinationSum2(new int[]{14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12}, 27);
        combinationSum2(new int[]{2, 2, 2, 2, 2}, 8);

    }


}
