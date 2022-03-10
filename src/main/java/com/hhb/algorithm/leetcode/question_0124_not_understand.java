package com.hhb.algorithm.leetcode;

/**
 * @description:124. 二叉树中的最大路径和 https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 * @author: huanghongbo
 * @date: 2021-09-15 15:04
 **/
public class question_0124_not_understand {

    static int maxVal = Integer.MIN_VALUE;


    static public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPathSum2(root);
        return maxVal;
    }

    static public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 为什么要和0比较
        int leftValue = Math.max(maxPathSum2(root.left), 0);
        int rightValue = Math.max(maxPathSum2(root.right), 0);
        maxVal = Math.max(leftValue + rightValue + root.val, maxVal);
        // 这一步有点不太理解
        return Math.max(root.val + leftValue, root.val + rightValue);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(-10);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        maxPathSum(treeNode1);

    }

}
