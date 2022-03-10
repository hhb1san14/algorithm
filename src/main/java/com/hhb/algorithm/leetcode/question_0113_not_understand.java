package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:113. 路径总和 II https://leetcode-cn.com/problems/path-sum-ii/
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * <p>
 * <p>
 * @author: huanghongbo
 * @date: 2021-09-15 10:40
 **/
public class question_0113_not_understand {

    /**
     * 广度优先算法，利用三个队列，时间复杂度O(n)
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> resultQueue = new LinkedList<>();
        Queue<List<Integer>> listQueue = new LinkedList<>();
        queue.offer(root);
        resultQueue.offer(root.val);
        temp.add(root.val);
        listQueue.offer(temp);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                Integer value = resultQueue.poll();
                List<Integer> listPoll = listQueue.poll();
                if (treeNode.left == null && treeNode.right == null && value == targetSum) {
                    list.add(new ArrayList<>(listPoll));
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                    resultQueue.offer(value + treeNode.left.val);
                    List<Integer> tempList = new ArrayList<>(listPoll);
                    tempList.add(treeNode.left.val);
                    listQueue.offer(tempList);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                    resultQueue.offer(value + treeNode.right.val);
                    List<Integer> tempList = new ArrayList<>(listPoll);
                    tempList.add(treeNode.right.val);
                    listQueue.offer(tempList);
                }
                size--;
            }
        }
        return list;
    }


    /**
     * 深度优先搜索，有点还没太明白
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        pathSum(root, targetSum, list, tempList);
        return list;
    }

    private static void pathSum(TreeNode root, int targetSum, List<List<Integer>> list, List<Integer> tempList) {
        if (root == null) {
            return;
        }
        tempList.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            list.add(new ArrayList<>(tempList));
            //主要是这块为什么不能return
//            return;
        }
        pathSum(root.left, targetSum, list, tempList);
        pathSum(root.right, targetSum, list, tempList);
        tempList.remove(tempList.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(13);
        TreeNode treeNode8 = new TreeNode(4);
        TreeNode treeNode9 = new TreeNode(5);
        TreeNode treeNode10 = new TreeNode(1);

        treeNode1.left = treeNode2;
        treeNode2.left = treeNode4;
        treeNode4.left = treeNode5;
        treeNode4.right = treeNode6;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode7;
        treeNode3.right = treeNode8;
        treeNode8.left = treeNode9;
        treeNode8.right = treeNode10;
        pathSum2(treeNode1, 22);

    }


}
