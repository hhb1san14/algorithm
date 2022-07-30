package com.hhb.algorithm.leetcode;

import java.util.*;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>F
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 *
 * @Desc: https://leetcode.cn/problems/n-queens/
 */
public class question_0051 {


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        //记录每一行皇后的位置
        int[] queues = new int[n];
        Arrays.fill(queues, -1);
        //保存某列不可以选择
        Set<Integer> cols = new HashSet<>();
        // 保存撇不可以保存数据
        Set<Integer> pies = new HashSet<>();
        // 保存捺不可以保存数据
        Set<Integer> nas = new HashSet<>();
        //递归
        backtrack(list, queues, cols, pies, nas, n, 0);
        //返回结果
        return list;
    }

    private void backtrack(List<List<String>> list, int[] queues, Set<Integer> cols, Set<Integer> pies, Set<Integer> nas, int n, int row) {
        if (n == row) {
            //拼装结果
            List<String> result = getResult(queues, n);
            list.add(result);
            return;
        }
        for (int i = 0; i < n; i++) {
            //验证是否在同一行/同一个撇/同一个捺
            if (cols.contains(i) || pies.contains(row + i) || nas.contains(row - i)) {
                continue;
            }
            //同一列的数据
            //0 0 1 0
            //0 0 1 0
            //0 0 1 0
            //0 0 1 0
            cols.add(i);
            //同一撇的数据， row + i
            //1 0 0 0
            //0 1 0 0
            //0 0 1 0
            //1 1 1 1
            pies.add(row + i);
            //同一捺的数据
            //0 0 0 1
            //0 0 1 0
            //0 1 0 0
            //1 0 0 0
            nas.add(row - i);
            //将结果保存，保存的结果就是几行皇后存放的位置
            queues[row] = i;
            //进入到下一层
            backtrack(list, queues, cols, pies, nas, n, row + 1);
            //将当前行本次选择的数据移除
            queues[row] = -1;
            //将本次选择数据对应的列的数据移除
            cols.remove(i);
            //将本次选择数据对应的撇的数据移除
            pies.remove(row + i);
            //将本次选择数据对应的捺的数据移除
            nas.remove(row - i);
        }
    }


    public List<String> getResult(int[] queues, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queues.length; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queues[i]] = 'Q';
            list.add(new String(row));
        }
        return list;
    }


    public static void main(String[] args) {
        question_0051 obj = new question_0051();
        System.err.println(obj.solveNQueens(4));
    }
}
