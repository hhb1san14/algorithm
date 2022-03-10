package com.hhb.algorithm.leetcode;


/**
 * @description:48. 旋转图像 https://leetcode-cn.com/problems/rotate-image/
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * 示例 3：
 * <p>
 * 输入：matrix = [[1]]
 * 输出：[[1]]
 * 示例 4：
 * <p>
 * 输入：matrix = [[1,2],[3,4]]
 * 输出：[[3,1],[4,2]]
 *  
 * <p>
 * 提示：
 * <p>
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 * @author: huanghongbo
 * @date: 2021-10-09 13:49
 **/
public class question_0048 {
    public static void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int[][] temp = matrix.clone();
        for (int i = 0; i < matrix.length; i++) {
            temp[i] = matrix[i].clone();
        }
        int indexRight = matrix.length - 1;
        for (int i = 0; i < temp.length; i++) {
            int[] temps = temp[i];
            for (int j = 0; j < temps.length; j++) {
                matrix[j][indexRight] = temps[j];
            }
            indexRight--;
        }
    }

    public static void main(String[] args) {
        rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
