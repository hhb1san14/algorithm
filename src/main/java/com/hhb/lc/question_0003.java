package com.hhb.lc;

/**
 * @author hhb
 * @date 2022/6/8
 * @description
 */
public class question_0003 {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = 1;
        String temp = s.substring(left, right);
        while (left < s.length() && right < s.length()) {
            if (!temp.contains(String.valueOf(s.charAt(right)))) {
                right++;
                temp = s.substring(left, right);
            } else {
                left++;
                temp = s.substring(left, right);
            }
            max = Math.max(temp.length(), max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.err.println(lengthOfLongestSubstring("abcabcbb"));
    }


}
