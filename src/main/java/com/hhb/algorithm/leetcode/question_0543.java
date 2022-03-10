package com.hhb.algorithm.leetcode;

/**
 * @description:543. 二叉树的直径 https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *  
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *  
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * @author: huanghongbo
 * @date: 2021-08-31 18:09
 **/
public class question_0543 {

    static int result = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result;
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode4.left = treeNode9;
        treeNode5.left = treeNode7;
        treeNode5.right = treeNode6;
        treeNode7.left = treeNode8;
        diameterOfBinaryTree(treeNode1);
    }


}
