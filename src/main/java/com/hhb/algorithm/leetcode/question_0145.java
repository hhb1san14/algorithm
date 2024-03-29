package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @author: huanghongbo
 * @date: 2021-06-21 11:35
 **/
public class question_0145 {

    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;

    }

    private static void postorderTraversal(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }

    public static void main(String[] args) {
        //                  1
        //       2                      6
        //  3       4             7            8
        //              5             9     10


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
        root.left = left1;
        root.right = right1;
        left1.left = left2;
        left1.right = left3;
        left3.right = left4;
        right1.left = right2;
        right1.right = right3;
        right2.right = right4;
        right3.left = right5;
        // [3, 5, 4, 2, 9, 7, 10, 8, 6, 1]
        List<Integer> list = postorderTraversalN(root);
        System.err.println(list);


    }

    public static List<Integer> postorderTraversalN(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode treeNode = stack.pop();
            TreeNode right = treeNode.right;
            if (right != null) {
                treeNode.right = null;
                stack.push(treeNode);
                root = right;
            } else {
                list.add(treeNode.val);
            }

        }
        return list;
    }


    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode treeNode = stack.pop();
            if (treeNode.right != null) {
                root = treeNode.right;
                treeNode.right = null;
                stack.push(treeNode);
            } else {
                list.add(treeNode.val);
            }
        }
        return list;
    }

}
