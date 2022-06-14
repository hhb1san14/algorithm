package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int max = Integer.MIN_VALUE;
        int left = 0;
        //key：字符串的每一个字符的值 value: 该字符的索引
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // s="abba"
                //假设当前left = 0，i = 2，此时无重复子串为ab，最大长度为2,
                //当i = 2的时候，map中原来含有字符b,所以left 应该等于map中字符b的索引+1.也就是left = 2
                // 当 i= 3的时候，map：{a:0,b:2},如果完全按照上面的逻辑，left = 0+ 1,（a的索引+1）
                // 但是由于之前left都已经为2了，所以此时left应该是max(left,0+1(a的索引+1))
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            //将该字符的最新的索引放到map中
            map.put(s.charAt(i), i);
            //无重复字符串的长度是最右的的索引+1（右指针） - left(左指针)
            max = Math.max(max, i + 1 - left);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        System.err.println(lengthOfLongestSubstring(str));
    }
}
