package com.hhb.algorithm.leetcode;

/**
 * @description:223. 矩形面积  https://leetcode-cn.com/problems/rectangle-area/
 * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
 * <p>
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 * <p>
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * 输出：45
 * 示例 2：
 * <p>
 * 输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * 输出：16
 *  
 * <p>
 * 提示：
 * <p>
 * -10^4 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10^4
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-09-30 11:17
 **/
public class question_0223 {
    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        // 不相交的时候覆盖面积
        int area = Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2) + Math.abs(bx1 - bx2) * Math.abs(by1 - by2);
        // 不相交的条件，四种情况
        //1: 第一个图形在第二个图形下方：ay2 < by1
        //2: 第一个图形在第二个图形左侧：ax2 < bx1
        //3: 第一个图形在第二个图形上方：ay1 > by2
        //4: 第一个图形在第二个图形右侧：ax1 > bx2
        if (ay2 < by1 || ax2 < bx1 || ay1 > by2 || ax1 > bx2) {
            return area;
        }
        // 相交的计算方式，两个矩阵面积相加 - 相交的面积
        return area - Math.abs(Math.max(ax1, bx1) - Math.min(ax2, bx2)) * Math.abs(Math.max(ay1, by1) - Math.min(ay2, by2));
    }

    public static void main(String[] args) {
        System.err.println(computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
    }


}
