package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:144. 二叉树的前序遍历:https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * @author: huanghongbo
 * @date: 2021-06-21 10:38
 **/
public class question_0144 {


    /**
     * 递归方式
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;

    }

    public static void preorderTraversal(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        list.add(treeNode.val);
        preorderTraversal(treeNode.left, list);
        preorderTraversal(treeNode.right, list);
    }


    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        while (root != null && !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }


        }

        return list;

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
        List<Integer> list = preorderTraversal4(root);
        System.err.println(list);
    }
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal2(root, list);
        return list;
    }

    private static void preorderTraversal2(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversal2(root.left, list);
        preorderTraversal2(root.right, list);
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.add(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pop.right != null) {
                root = pop.right;
            }
        }
        return list;
    }


    public static List<Integer> preorderTraversal4(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
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
}
