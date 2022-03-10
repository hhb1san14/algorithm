package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:430. 扁平化多级双向链表 https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：
 * <p>
 * 输入的多级列表如下图所示：
 * <p>
 * <p>
 * <p>
 * 扁平化后的链表如下图：
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 解释：
 * <p>
 * 输入的多级列表如下图所示：
 * <p>
 * 1---2---NULL
 * |
 * 3---NULL
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 *  
 * <p>
 * 如何表示测试用例中的多级链表？
 * <p>
 * 以 示例 1 为例：
 * <p>
 * 1---2---3---4---5---6--NULL
 * |
 * 7---8---9---10--NULL
 * |
 * 11--12--NULL
 * 序列化其中的每一级之后：
 * <p>
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。
 * <p>
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * 合并所有序列化结果，并去除末尾的 null 。
 * <p>
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: huanghongbo
 * @date: 2021-09-24 09:18
 **/
public class question_0430 {

    public Node flatten(Node head) {
        List<Node> list = new ArrayList<>();
        flatten(head, list);
        if (list.size() == 0) {
            return head;
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).child = null;
            if (i == 0) {
                list.get(i).prev = null;
            }
            if (i != list.size() - 1) {
                list.get(i).next = list.get(i + 1);
            }
            if (i != 0) {
                list.get(i).prev = list.get(i - 1);
            }
            if (i == list.size() - 1) {
                list.get(i).next = null;
            }
        }
        return list.get(0);
    }

    public void flatten(Node head, List<Node> list) {
        if (head == null) {
            return;
        }
        list.add(head);
        flatten(head.child, list);
        flatten(head.next, list);
    }

}
