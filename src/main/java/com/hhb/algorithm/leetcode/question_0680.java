package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-05-19 10:21
 * @Description: 验证回文字符串 Ⅱ   https://leetcode-cn.com/problems/valid-palindrome-ii/
 * <p>
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */
public class question_0680 {

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int index = 1;
        boolean flag = true;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right) && index == 1) {
                index--;
                left++;
                continue;
            }
            if (s.charAt(left) != s.charAt(right) && index == 0) {
                flag = false;
                break;
            }
            left++;
            right--;
        }
        if (flag) {
            return true;
        }

        left = 0;
        right = s.length() - 1;
        index = 1;
        flag = true;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right) && index == 1) {
                index--;
                right--;
                continue;
            }
            if (s.charAt(left) != s.charAt(right) && index == 0) {
                flag = false;
                break;
            }
            left++;
            right--;
        }
        if (flag) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.err.println(validPalindrome(str));
    }

}
