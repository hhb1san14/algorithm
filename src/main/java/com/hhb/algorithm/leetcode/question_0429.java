package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hhb
 * @date 2022/7/14
 * @description 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * <p>
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *  
 * 提示：
 * 树的高度不会超过 1000
 * 树的节点总数在 [0, 10^4] 之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class question_0429 {

    public static List<List<Integer>> levelOrder(Nodes root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Nodes> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                Nodes node = queue.poll();
                list.add(node.val);
                List<Nodes> children = node.children;
                if (children != null) {
                    for (Nodes n : children) {
                        queue.offer(n);
                    }
                }
                size--;
            }
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}
