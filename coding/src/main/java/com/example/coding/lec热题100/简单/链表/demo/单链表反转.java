package com.example.coding.lec热题100.简单.链表.demo;

import com.example.coding.lec经典150.链表.model.ListNode;

/**
 * @author liutc
 * @date 2024/5/30 17:04
 */

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class 单链表反转 {

    //1->2->3-4->null
    //4->3->2->1->null
    public ListNode reverseList(ListNode head) { //4
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;

            head.next = pre;
            pre = head;

            head = next;
        }

        return pre;
    }

}
