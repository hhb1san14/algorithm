package com.hhb.algorithm.leetcode;

import java.util.Arrays;

/**
 * @description: 242. 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * @author: huanghongbo
 * @date: 2021-10-08 17:42
 **/
public class question_0242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        int index = 0;
        while (index < s1.length) {
            if (s1[index] == t1[index]) {
                index++;
                continue;
            }
            return false;
        }
        return true;
    }

}
