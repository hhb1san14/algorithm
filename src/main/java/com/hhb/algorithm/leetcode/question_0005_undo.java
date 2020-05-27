package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-05-21 09:37
 * @Description: 最长回文子串 https://leetcode-cn.com/problems/longest-palindromic-substring/
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class question_0005_undo {


    public static String longestPalindrome(String s) {

        String result = "";
        if (s == null) {
            return null;
        }
        if ("".equals(s)) {
            return result;
        }

        if (s.length() == 1) {
            return s;
        }

        int index = s.length();
        int start = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            start = i;
            for (int j = index - 1; j > 0; j--) {
                if (j >= i) {
                    if (s.charAt(start) == s.charAt(j)) {
                        min = Math.min(start, min);
                        max = Math.max(j, max);
                        start++;
                        continue;
                    }else{
                        min = Integer.MAX_VALUE;
                        max = Integer.MIN_VALUE;
                    }
                }
            }
            if (max > 0 && max - min >= 0 && result.length() < (max - min + 1)) {
                result = s.substring(min, max + 1);
            }
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }
        return result;
    }


    public static void main(String[] args) {
//        String str = "aaabaaaa";
//        System.err.println(longestPalindrome(str));
        int j = 0;
        for (int i = 0; i < 10; i++) {
            j = j++;
        }
        System.out.println(j);

    }
}
