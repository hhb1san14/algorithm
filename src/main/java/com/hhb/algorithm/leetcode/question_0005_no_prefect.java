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
public class question_0005_no_prefect {

    /**
     * 自己写的，正确，但是超出时间限制。
     *
     * @param s
     * @return
     */
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
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String str = s.substring(i, j + 1);
                if (!isPalindrome(str)) {
                    continue;
                }
                if (str.length() > maxLength) {
                    maxLength = str.length();
                    result = str;
                }
            }

        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
//        String str = "bb";
        String str = "aaabaaaa";

        System.err.println(longestPalindrome(str));

    }
}
