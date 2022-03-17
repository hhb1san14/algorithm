package com.hhb.algorithm.leetcode;

/**
 * @author hhb
 * @date 2022/3/17
 * @description 720. 词典中最长的单词 https://leetcode-cn.com/problems/longest-word-in-dictionary/
 * <p>
 * 给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。
 * <p>
 * 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
 * 示例 2：
 * <p>
 * 输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 30
 * 所有输入的字符串 words[i] 都只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class question_0720_undo {

    public static void main(String[] args) {
//        String[] words = {"w", "wo", "wor", "worl", "world"};
//        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
//        String[] words = {"b", "br", "bre", "brea", "break", "breakf", "breakfa", "breakfas", "breakfast",
//                "l", "lu", "lun", "lunc", "lunch", "d", "di", "din", "dinn", "dinne", "dinner"};
//        String[] words = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        String[] words = {"t", "ti", "tig", "tige", "tiger", "e", "en", "eng", "engl", "engli", "englis", "english", "h", "hi", "his", "hist", "histo", "histor", "history"};
        System.err.println(longestWord(words));
    }

    public static String longestWord(String[] words) {
        int max = 0;
        String maxWord = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int temp = 0;
            for (int j = 0; j < words.length; j++) {
                if (word.contains(words[j])) {
                    temp++;
                }
                if (word.equals(words[j])) {
                    break;
                }
            }
            System.err.println("word:" + word + ",次数：" + temp);
            if (temp > max) {
                max = temp;
                maxWord = word;
            } else if (temp == max) {
                maxWord = maxWord.compareTo(word) > 0 ? word : maxWord;
            }
        }
        return maxWord;
    }

}
