package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huanghongbo
 * @Date: 2020-05-20 19:13
 * @Description: 无重复字符的最长子串 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class question_0003_no_perfect {


    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (s == null || "".equals(s)) {
            return result;
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (list.contains(s.charAt(j))) {
                    break;
                }
                list.add(s.charAt(j));
            }
            result = Math.max(result, list.size());
            list.clear();
        }
        return result;

    }

    public static void main(String[] args) {
        String str = "pwwkew";
        System.err.println(lengthOfLongestSubstring(str));
    }
}
