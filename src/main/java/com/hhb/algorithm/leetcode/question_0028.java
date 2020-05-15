package com.hhb.algorithm.leetcode;


/**
 * @author: huanghongbo
 * @Date: 2020-05-15 09:34
 * @Description: 实现 strStr() https://leetcode-cn.com/problems/implement-strstr/
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 */
public class question_0028 {

    public static int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        if ((haystack == null || "".equals(haystack)) && needle != null && !"".equals(needle)) {
            return -1;
        }
        int index = 0;
        int result = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(index)) {
                result = i;
                if (index < needle.length()) {
                    index++;
                }
                if (index == needle.length()) {
                    return result - needle.length() + 1;
                }
                continue;
            }
            if (index > 0) {
                i = i - index;
            }
            index = 0;

        }
        if (index == needle.length()) {
            return result - needle.length() + 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issip";
        int i = strStr(haystack, needle);
        System.err.println(i);
    }


}
