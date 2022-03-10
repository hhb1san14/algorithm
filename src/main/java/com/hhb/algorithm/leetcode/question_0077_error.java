package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 77. 组合  https://leetcode-cn.com/problems/combinations/
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 * @author: huanghongbo
 * @date: 2021-09-13 16:06
 **/
public class question_0077_error {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        combine(list, tempList, n, k, 1);
        return list;
    }

    private static void combine(List<List<Integer>> list, List<Integer> tempList, int n, int k, int index) {
        if (k == tempList.size()) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = index; i <= n; i++) {
            if (tempList.contains(i)) {
                continue;
            }
            tempList.add(i);
            combine(list, tempList, n, k, index++);
            tempList.remove(tempList.size() - 1);
        }

    }

    public static void main(String[] args) {
        combine(3, 3);


    }
}
