package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:94. 二叉树的中序遍历 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * @author: huanghongbo
 * @date: 2021-06-21 11:33
 **/
public class question_0094 {


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }


    // 自己利用栈的方式，迭代写中序遍历
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            root = treeNode.right;
        }


        return list;
    }


    public static void main(String[] args) {
        //                  1
        //       2                      6
        //  3       4             7            8
        //11            5             9     10


        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        TreeNode left3 = new TreeNode(4);
        TreeNode left4 = new TreeNode(5);
        TreeNode right1 = new TreeNode(6);
        TreeNode right2 = new TreeNode(7);
        TreeNode right3 = new TreeNode(8);
        TreeNode right4 = new TreeNode(9);
        TreeNode right5 = new TreeNode(10);
        TreeNode left5 = new TreeNode(11);
        root.left = left1;
        root.right = right1;
        left1.left = left2;
        left1.right = left3;
        left2.left = left5;
        left3.right = left4;
        right1.left = right2;
        right1.right = right3;
        right2.right = right4;
        right3.left = right5;
        List<Integer> list = inorderTraversal(root);
        System.err.println(list);
        System.err.println(inorderTraversal2(root));


    }
}
