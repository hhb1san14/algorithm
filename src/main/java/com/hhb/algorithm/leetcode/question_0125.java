package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-05-19 09:59
 * @Description: 验证回文串 https://leetcode-cn.com/problems/valid-palindrome/
 * <p>
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class question_0125 {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s == null || "".equals(s)) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (!isNumberOrLetter(s.charAt(left))) {
                left++;
                continue;
            }
            if (!isNumberOrLetter(s.charAt(right))) {
                right--;
                continue;
            }
            if (c1 != c2) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isNumberOrLetter(char c) {
        if (c >= 48 && c <= 57) {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String str = "race a car";
        System.err.println(isPalindrome(str));
    }
}
