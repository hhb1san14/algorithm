package com.hhb.algorithm.leetcode;


/**
 * @description: 567. 字符串的排列 https://leetcode-cn.com/problems/permutation-in-string/
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 * @author: huanghongbo
 * @date: 2021-07-26 13:36
 **/
public class question_0567_no_perfect {

    public static boolean checkInclusion(String s1, String s2) {
        int[] s1Arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Arr[s1.charAt(i) - 'a']++;
        }
        int right = s1.length();
        int left = 0;

        while (right <= s2.length()) {
            //截取指定长度字符串，并进行翻转
            String str = s2.substring(left, right);
            int[] s2Arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                s2Arr[str.charAt(i) - 'a']++;
            }
            if (isValid(s1Arr, s2Arr)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }


    public static boolean isValid(int[] s1Arr, int[] s2Arr) {
        boolean result = true;
        for (int i = 0; i < s1Arr.length; i++) {
            if (s1Arr[i] != s2Arr[i]) {
                result = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String s1 = "adc";
        String s2 = "dcda";
        System.err.println(checkInclusion(s1, s2));


    }


}
