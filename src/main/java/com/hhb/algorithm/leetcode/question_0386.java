package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author hhb
 * @date 2022/4/18
 * @description 386. 字典序排数 https://leetcode-cn.com/problems/lexicographical-numbers/
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 * 示例 1：
 *
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：[1,2]
 *
 * 提示：
 *
 * 1 <= n <= 5 * 10^4
 */
public class question_0386 {

    // 自己的想法，利用TreeSet字典序，将数据进行字典序排序，然后转换成List
    public static List<Integer> lexicalOrder(int n) {
        TreeSet<String> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(String.valueOf(i));
        }
        return new ArrayList<>(set).stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.err.println(lexicalOrder(13));
    }

}
