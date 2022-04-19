package com.hhb.algorithm.leetcode;

/**
 * @author hhb
 * @date 2022/4/19
 * @description821. 字符的最短距离 https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * <p>
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 * <p>
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "loveleetcode", c = "e"
 * 输出：[3,2,1,0,1,0,0,1,2,2,1,0]
 * 解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
 * 距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
 * 距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
 * 对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
 * 距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
 * 示例 2：
 * <p>
 * 输入：s = "aaab", c = "b"
 * 输出：[3,2,1,0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class question_0821 {
    //双重for循环，暴力解
    public static int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == c) {
                result[i] = 0;
                continue;
            }
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == c) {
                    int abs = Math.abs(j - i);
                    if (result[i] == 0) {
                        result[i] = abs;
                    } else {
                        result[i] = Math.min(abs, result[i]);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = shortestToChar("loveleetcode", 'e');
        for (int i = 0; i < result.length; i++) {
            System.err.println(result[i]);
        }
    }

}
