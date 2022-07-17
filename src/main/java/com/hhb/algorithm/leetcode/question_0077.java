package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhb
 * @date 2022/7/17
 * @description 77. 组合 https://leetcode.cn/problems/combinations/
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
 */
public class question_0077 {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        combine(n, k, list, new ArrayList<Integer>(), 1);
        return list;
    }

    public static void combine(int n, int k, List<List<Integer>> list, ArrayList<Integer> temp, int index) {
        if (temp.size() == k) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <= n; i++) {
            if (temp.contains(i)) {
                continue;
            }
            temp.add(i);
            combine(n, k, list, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = combine(4, 2);
        System.err.println(list);
    }
}
