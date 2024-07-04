package com.example.coding.lec经典150.链表;


import com.example.coding.lec经典150.链表.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */

/**
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 */
public class 分隔链表 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(2);

        ListNode partition = partition(l1, 3);
        System.out.println(partition);
    }

    public static ListNode partition(ListNode head, int x) {
        List<ListNode> pre = new ArrayList<>();
        List<ListNode> last = new ArrayList<>();

        while (head != null) {
            if (head.val < x) {
                pre.add(head);
            } else {
                last.add(head);
            }
            head = head.next;
        }

        //head = [1,4,3,2,5,2], x = 3
        //[1,2,2,4,3,5]
        ListNode listNode = new ListNode(0);
        ListNode first = null;
        if (!pre.isEmpty()) {
            for (int i = 0; i < pre.size(); i++) {
                ListNode node = pre.get(i);
                listNode.next = node;
                node.next = null;
                if (first == null) {
                    first = listNode.next;
                }
                listNode = listNode.next;
            }
        }
        if (!last.isEmpty()) {
            for (int i = 0; i < last.size(); i++) {
                ListNode node = last.get(i);
                listNode.next = node;
                node.next = null;
                if (first == null) {
                    first = listNode.next;
                }
                listNode = listNode.next;
            }
        }

        return first;
    }
}
