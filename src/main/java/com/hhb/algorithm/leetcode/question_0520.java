package com.hhb.algorithm.leetcode;

/**
 * @author: huanghongbo
 * @Date: 2020-05-11 13:44
 * @Description: 检测大写字母 https://leetcode-cn.com/problems/detect-capital/
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * <p>
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "USA"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "FlaG"
 * 输出: False
 * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 */
public class question_0520 {

    public static boolean detectCapitalUse(String word) {
        int upper = 0;
        int lower = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) < 'a') {
                upper++;
            } else {
                lower++;
            }
        }

        if (upper == word.length() || lower == word.length() || ((upper == 1) && word.charAt(0) < 'a')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
