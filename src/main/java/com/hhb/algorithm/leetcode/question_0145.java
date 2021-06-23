package com.hhb.algorithm.leetcode;

import java.util.*;

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


    public static List<Integer> postorderTraversal2(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();
        if (root == null) {
            return null;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            result.push(treeNode.val);
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }

        while (!result.isEmpty()) {
            list.add(result.pop());
        }
        return list;

    }


    public static void main(String[] args) {
        //                  1
        //       2                      6
        //  3       4             7            8
        //              5             9     10

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("","");
        HashSet<String> set = new HashSet<>();
        set.add("");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

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
        System.err.println(postorderTraversal(root));
        System.err.println(postorderTraversal2(root));


    }

}
