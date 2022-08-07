package com.hhb.algorithm.leetcode;

import java.util.*;

/**
 * @ClassName: question_0126
 * @Date: 2022/8/6 22:55
 * @Author: huanghongbo
 * @Description:126. 单词接龙 II https://leetcode.cn/problems/word-ladder-ii/description/
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 * <p>
 * 每对相邻的单词之间仅有单个字母不同。
 * 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * 解释：存在 2 种最短的转换序列：
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 * 示例 2：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：[]
 * 解释：endWord "cog" 不在字典 wordList 中，所以不存在符合要求的转换序列。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= beginWord.length <= 5
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 500
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有单词 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-ladder-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class question_0126_undo {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> list = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return list;
        }
        //BFS广度优先，生成图
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        List<String> visitList = new ArrayList<>();
        visitList.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Map<String, List<String>> graph = new HashMap<>();
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String str = queue.poll();
                List<String> tempList = new ArrayList<>();
                for (int i = 0; i < wordList.size(); i++) {
                    if (wordList.get(i).equals(str)) {
                        continue;
                    }

                    int index = 0;
                    for (int j = 0; j < wordList.get(i).length(); j++) {
                        if (wordList.get(i).charAt(j) == str.charAt(j)) {
                            continue;
                        }
                        index++;
                    }
                    if (index > 1) {
                        continue;
                    }
                    if (index == 1) {
                        if (visitList.contains(wordList.get(i))) {
                            continue;
                        }
                        tempList.add(wordList.get(i));
                        Integer count = map.getOrDefault(str, 0) + 1;
                        map.put(wordList.get(i), count);
                        visitList.add(wordList.get(i));
                        queue.offer(wordList.get(i));
                        if (wordList.get(i).equals(endWord)) {
                            flag = true;
                        }
                    }
                }
                if (tempList.size() > 0) {
                    graph.put(str, tempList);
                }
                size--;
            }
        }
        Integer result = map.get(endWord);

        if (flag) {
            List<String> l = new ArrayList<>();
            l.add(beginWord);
            dfs(list, l, beginWord, endWord, graph);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() > result) {
                list.remove(i);
            }
        }
        return list;
    }

    public void dfs(List<List<String>> list, List<String> tempList, String startWord, String endWord, Map<String, List<String>> map) {
        if (startWord.equals(endWord)) {
            ArrayList<String> temp = new ArrayList<>(tempList);
            list.add(temp);
            return;
        }
        System.err.println(startWord);
        List<String> t = map.get(startWord);
        for (int i = 0; i < t.size(); i++) {
            tempList.add(t.get(i));
            dfs(list, tempList, t.get(i), endWord, map);
            tempList.remove(tempList.size() - 1);
        }
    }


//    public static void main(String[] args) {
//        question_0126 question_0126 = new question_0126();
//        List<String> list = new ArrayList<>();
//        list.add("hot");
//        list.add("dot");
//        list.add("dog");
//        list.add("lot");
//        list.add("log");
//        list.add("cog");
//        System.err.println(question_0126.findLadders("hit", "cog", list));
////        List<String> list = new ArrayList<>();
////        list.add("hot");
////        list.add("dot");
////        list.add("dog");
////        list.add("lot");
////        list.add("log");
////        System.err.println(question_0127.ladderLength("hit", "cog", list));
//    }
}
