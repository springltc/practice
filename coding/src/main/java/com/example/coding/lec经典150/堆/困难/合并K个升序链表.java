package com.example.coding.lec经典150.堆.困难;

/**
 * @author liutc
 * @date 2024/7/31 09:47
 */

import com.example.coding.lec经典150.链表.model.ListNode;

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
//https://leetcode.cn/problems/merge-k-sorted-lists/description/
public class 合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        //小根堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            queue.add(list);
        }

        if (queue.isEmpty()) {
            return null;
        }

        ListNode poll = queue.poll();
        ListNode pre = poll;
        if (poll.next != null) {
            queue.add(pre.next);
        }
        while (!queue.isEmpty()) {
            ListNode listNode = queue.poll();
            pre.next = listNode;
            pre = listNode;
            if (listNode.next != null) {
                queue.add(listNode.next);
            }
        }

        return poll;
    }
}
