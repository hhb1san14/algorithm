package com.hhb.algorithm.leetcode;

import java.util.*;

/**
 * @ClassName: question_0127
 * @Date: 2022/8/6 22:09
 * @Author: huanghongbo
 * @Description:127. 单词接龙 https://leetcode.cn/problems/word-ladder/
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 * <p>
 * 每一对相邻的单词只差一个字母。
 *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 示例 2：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 */
public class question_0127 {

    /**
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        //存放已经访问的字符串
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        queue.offer(beginWord);
        map.put(beginWord, 1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String str = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    //两个单词长度不同，直接下一步
                    if (wordList.get(i).length() != str.length()) {
                        continue;
                    }
                    //如果当前两个单词相等，直接返回
                    if (wordList.get(i).equals(str)) {
                        continue;
                    }
                    //遍历当前单词的每一个字符位置，判断是否相等
                    int index = 0;
                    for (int j = 0; j < wordList.get(i).length(); j++) {
                        if (str.charAt(j) == wordList.get(i).charAt(j)) {
                            continue;
                        }
                        index++;
                        if (index > 1) {
                            break;
                        }
                    }
                    //如果只有一个字符是错误的，其他字符是相等的，说明两个字符可以转化
                    if (index == 1) {
                        //为了防止是A->B->A,判断是否存在已经访问过的集合中
                        if (list.contains(wordList.get(i))) {
                            continue;
                        }
                        //如果没访问过，将该字符串加入到queue中
                        queue.offer(wordList.get(i));
                        //步数+1
                        int count = map.getOrDefault(str, 0) + 1;
                        map.put(wordList.get(i), count);
                        //将该字符放入访问过的集合中，方式A->B->A,死循环
                        list.add(wordList.get(i));
                    }
                }
                size--;
            }
        }
        return map.getOrDefault(endWord, 0);
    }

    public static void main(String[] args) {
        question_0127 question_0127 = new question_0127();
//        List<String> list = new ArrayList<>();
//        list.add("hot");
//        list.add("dot");
//        list.add("dog");
//        list.add("lot");
//        list.add("log");
//        list.add("cog");
//        System.err.println(question_0127.ladderLength("hit", "cog", list));
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        System.err.println(question_0127.ladderLength("hit", "cog", list));
    }
}
