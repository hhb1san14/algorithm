package com.hhb.algorithm.leetcode;


/**
 * @description: 557. 反转字符串中的单词 III  https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *  
 * 示例：
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 * 提示：
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * @author: huanghongbo
 * @date: 2021-07-16 08:53
 **/
public class question_0557_no_perfect {

    /**
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }

        String result = "";
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            String temp = reverseWord(arr[i]);
            result += temp;
            if (i != arr.length - 1) {
                result += " ";
            }
        }
        return result;

    }


    public static String reverseWord(String word) {
        if (word == null || "".equals(word)) {
            return null;
        }
        char[] chars = word.toCharArray();

        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String s = reverseWords("Let's take LeetCode contest");
        System.err.println(s);

    }

}
