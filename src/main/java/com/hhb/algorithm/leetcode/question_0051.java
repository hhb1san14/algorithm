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
        //定义一个每层数据皇后所在的索引位置，并初始化数据
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        //记录皇后所在的列\撇\捺不能存放数据
        Set<Integer> cols = new HashSet<>();
        Set<Integer> nas = new HashSet<>();
        Set<Integer> pies = new HashSet<>();
        backStace(list, cols, nas, pies, queens, n, 0);
        return list;
    }

    /**
     * @param list
     * @param cols
     * @param nas
     * @param pies
     * @param queens
     * @param n
     * @param row
     */
    private void backStace(List<List<String>> list, Set<Integer> cols, Set<Integer> nas, Set<Integer> pies, int[] queens, int n, int row) {
        if (n == row) {
            list.add(getResult(queens, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            //判断所在列、撇、捺是否在皇后的攻击范围
            if (cols.contains(i) || nas.contains(row + i) || pies.contains(row - i)) {
                continue;
            }
            //将本层的皇后放在该位置
            queens[row] = i;
            //将本层皇后所在列放到不能存放数据的列集合中
            //0 0 1 0
            //0 0 1 0
            //0 0 1 0
            //0 0 1 0
            cols.add(i);
            //将本层皇后所在捺放到不能存放数据的捺集合中
            //1 0 0 0
            //0 1 0 0
            //0 0 1 0
            //0 0 0 1
            nas.add(row + i);
            //将本层皇后所在撇放到不能存放数据的撇集合中
            //0 0 0 1
            //0 0 1 0
            //0 1 0 0
            //1 0 0 0
            pies.add(row - i);
            //进入下一层
            backStace(list, cols, nas, pies, queens, n, row + 1);
            //清除当前层数据
            queens[row] = -1;
            cols.remove(i);
            nas.remove(row + i);
            pies.remove(row - i);
        }
    }

    /**
     * 生成最终结果，组装数据
     *
     * @param queens 记录了本次每个皇后在每层的索引位置
     * @param n      一共多少层
     * @return
     */
    private List<String> getResult(int[] queens, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //定义每层的结果m,并初始化数据
            char[] cArr = new char[n];
            Arrays.fill(cArr, '.');
            //获取皇后在每层的索引，并对该索引的位置的的结果集复Q
            cArr[queens[i]] = 'Q';
            list.add(new String(cArr));
        }
        return list;
    }


    public static void main(String[] args) {
        question_0051 obj = new question_0051();
        System.err.println(obj.solveNQueens(4));
    }
}
