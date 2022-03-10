package com.hhb.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:56. 合并区间 https://leetcode-cn.com/problems/merge-intervals/
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * @author: huanghongbo
 * @date: 2021-10-03 20:29
 **/
public class question_0056 {

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        // 先对数据进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        int[] temp = intervals[0];
        int[][] result = new int[intervals.length][2];
        int start = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            //如果后一个数组的第一个数比前一个数组的第二个数还大，说明两个区间不相交
            if (interval[0] > temp[1]) {
                result[start++] = temp;
                temp = interval;
            } else {
                // 第一个数取两个区间的最小值，第二个取两个数的最大值
                temp[0] = Math.min(temp[0], interval[0]);
                temp[1] = Math.max(temp[1], interval[1]);
            }
        }
        // 如果start == 0,说明上面的区间合并成了一个
        if (start == 0) {
            result[start] = temp;
        } else {
            //否则比较最后一个数与已有结果的最后一个是不是同一个，不是的话，进行赋值
            int[] tmp = result[start - 1];
            if (!(temp[0] == tmp[0] && temp[1] == tmp[1])) {
                result[start] = temp;
            }
        }
        // 重新复制数组
        return Arrays.copyOf(result, start + 1);
    }

    public static void main(String[] args) {
//        [[1,3],[2,6],[8,10],[15,18]]
        merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
//        merge(new int[][]{{1, 4}, {4, 6}});


    }
}
