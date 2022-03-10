package com.hhb.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:112. 路径总和 https://leetcode-cn.com/problems/path-sum/
 * <p>
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：false
 * @author: huanghongbo
 * @date: 2021-07-15 13:41
 **/
public class question_0112 {

    //深度优先
    public static boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum2(root.left, targetSum - root.val) || hasPathSum2(root.right, targetSum - root.val);
    }


    //广度优先
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();
        queue.offer(root);
        valueQueue.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int value = valueQueue.poll();

            if (node.left == null && node.right == null) {
                if (value == targetSum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                queue.offer(node.left);
                valueQueue.offer(value + node.left.val);
            }
            if (node.right != null) {
                queue.offer(node.right);
                valueQueue.offer(value + node.right.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
