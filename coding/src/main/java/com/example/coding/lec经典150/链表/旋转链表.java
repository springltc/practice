package com.example.coding.lec经典150.链表;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */

import com.example.coding.lec经典150.链表.model.ListNode;

import java.util.HashMap;

/**
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 */
public class 旋转链表 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);

        ListNode listNode = rotateRight(l1, 4);
        System.out.println(listNode);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        int length = getLength(head);
        HashMap<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        while (head != null) {
            map.put((index + k) % length, head);
            head = head.next;
            ++index;
        }

        ListNode node = new ListNode(0);
        ListNode first = null;
        for (int i = 0; i < length; i++) {
            ListNode listNode = map.get(i);
            node.next = listNode;
            listNode.next = null;
            if (first == null) {
                first = node.next;
            }
            node = node.next;
        }

        return first;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}
