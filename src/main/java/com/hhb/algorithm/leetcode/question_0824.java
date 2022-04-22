package com.hhb.algorithm.leetcode;

/**
 * @author hhb
 * @date 2022/4/22
 * @description 824. 山羊拉丁文 https://leetcode-cn.com/problems/goat-latin/
 * 给你一个由若干单词组成的句子 sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 * <p>
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 * <p>
 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 * 例如，单词 "apple" 变为 "applema" 。
 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词 "goat" 变为 "oatgma" 。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "I speak Goat Latin"
 * 输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * 示例 2：
 * <p>
 * 输入：sentence = "The quick brown fox jumped over the lazy dog"
 * 输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 */
public class question_0824 {

    public static String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i].charAt(0);
            if (c == 'A' || c == 'a'
                    || c == 'E' || c == 'e'
                    || c == 'I' || c == 'i'
                    || c == 'O' || c == 'o'
                    || c == 'U' || c == 'u') {
                arr[i] = arr[i] + "ma";
            } else {
                arr[i] = arr[i].substring(1) + arr[i].substring(0, 1) + "ma";
            }
            int index = i + 1;
            while (index > 0) {
                arr[i] = arr[i] + "a";
                index--;
            }
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.err.println(toGoatLatin("I speak Goat Latin"));
    }

}

