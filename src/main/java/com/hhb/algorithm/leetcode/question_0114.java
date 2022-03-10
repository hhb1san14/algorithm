package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:114. 二叉树展开为链表  https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-08-09 08:56
 **/
public class question_0114 {


    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        flatten(root, list);
        TreeNode temp = new TreeNode();
        TreeNode node = new TreeNode();
        temp.right = node;
        for (int i = 0; i < list.size(); i++) {
            TreeNode curr = new TreeNode(list.get(i).val);
            node.right = curr;
            node.left = null;
            node = curr;
        }
        root = temp.right;
        root = root.right;
    }

    /**
     * 看的答案
     *
     * @param root
     */
    public static void flatten2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        flatten(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode curr = list.get(i);
            TreeNode pre = list.get(i - 1);
            pre.left = null;
            pre.right = curr;
        }
    }

    public static void flatten(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        flatten(root.left, list);
        flatten(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode5;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode5.right = treeNode6;
        flatten(treeNode1);
    }


}
