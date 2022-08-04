package com.hhb.algorithm.leetcode;


import java.util.*;

/**
 * @ClassName: question_0433
 * @Date: 2022/8/2 19:45
 * @Author: huanghongbo
 * @Description:433. 最小基因变化 https://leetcode.cn/problems/minimum-genetic-mutation/
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * <p>
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * <p>
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 * 示例 1：
 * 输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * 输出：1
 * 示例 2：
 * 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * start.length == 8
 * end.length == 8
 * 0 <= bank.length <= 10
 * bank[i].length == 8
 * start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
 */
public class question_0433 {

    private char[] chars = {'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        for (String str : bank) {
            set.add(str);
        }
        Map<String, Integer> map = new HashMap<>();
        map.put(start,0);
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String str = queue.poll();
                for (int i = 0; i < str.length(); i++) {
                    StringBuilder sb = new StringBuilder(str);
                    for (int j = 0; j < chars.length; j++) {
                        sb.setCharAt(i, chars[j]);
                        if (!set.contains(sb.toString())) {
                            continue;
                        }
                        if(map.containsKey(sb.toString())){
                            continue;
                        }
                        queue.offer(sb.toString());
                        Integer count = map.get(str) + 1;
                        map.put(sb.toString(), count);
                        if (sb.toString().equals(end)) {
                            return count;
                        }
                    }
                }
                size--;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        question_0433 obj = new question_0433();
        System.err.println(obj.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"}));
    }
}
