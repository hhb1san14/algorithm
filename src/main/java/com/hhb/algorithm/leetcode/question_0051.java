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
        //存放哪些列不能被选中
        Set<Integer> cols = new HashSet<>();
        //存放那些撇不能被选中
        Set<Integer> pies = new HashSet<>();
        //存放那些捺不能被选中
        Set<Integer> nas = new HashSet<>();
        //用来存放每行哪个位置可以放N皇后
        int[] queues = new int[n];
        //把所有的数组的元素初始化为-1，
        Arrays.fill(queues, -1);
        backTrack(list, cols, pies, nas, queues, n, 0);
        return list;
    }

    private void backTrack(List<List<String>> list, Set<Integer> cols, Set<Integer> pies, Set<Integer> nas, int[] queues, int n, int row) {
        if (row == n) {
            //获取本次回溯的结果，并存放到list中
            list.add(getResult(queues, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            //判断该列或该撇或该捺是否存在该位置的的皇后
            if (cols.contains(i) || pies.contains(i + row) || nas.contains(row - i)) {
                continue;
            }
            //0 0 1 0
            //0 0 1 0
            //0 0 1 0
            //0 0 1 0
            cols.add(i);
            //1 0 0 0
            //0 1 0 0
            //0 0 1 0
            //0 0 0 1
            pies.add(row + i);
            //0 0 0 1
            //0 0 1 0
            //0 1 0 0
            //1 0 0 0
            nas.add(row - i);
            //第row层的位置要存放皇后的位置(从第0层开始，到n-1层)
            queues[row] = i;
            //进入到下一层数据
            backTrack(list, cols, pies, nas, queues, n, row + 1);
            //清除当前层数据
            queues[row] = -1;
            cols.remove(i);
            pies.remove(row + i);
            nas.remove(row - i);
        }
    }

    private List<String> getResult(int[] queues, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //创建结果集，每一行都需要一个结果集，并将结果集初始化为[....]
            char[] cArr = new char[n];
            Arrays.fill(cArr, '.');
            //获取每一行的要存放的索引，并在结果集该索引的位置上赋值Q
            cArr[queues[i]] = 'Q';
            list.add(new String(cArr));
        }
        return list;
    }


    public static void main(String[] args) {
        question_0051 obj = new question_0051();
        System.err.println(obj.solveNQueens(4));
    }
}
