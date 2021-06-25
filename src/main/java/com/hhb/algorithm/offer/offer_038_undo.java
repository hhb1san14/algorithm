package com.hhb.algorithm.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description: 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 * 限制：
 * 1 <= s 的长度 <= 8
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * @author: huanghongbo
 * @date: 2021-06-22 08:12
 **/
public class offer_038_undo {

    public static void main(String[] args) {


    }


    public String[] permutation(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        Set<Character> set = new HashSet<>();

        // 对字符串去重
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        Iterator<Character> iterator = set.iterator();

        while (iterator.hasNext()) {

        }

        return null;
    }


}
