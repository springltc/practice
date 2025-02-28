package com.example.coding.lec经典150.链表;

import com.example.coding.lec经典150.链表.model.ListNode;

/**
 * @author liutc
 * @date 2025/1/9 14:40
 */
public class 移除链表元素 {

    public static void main(String[] args) {
        System.out.println(3%2);
    }

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }

        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }

        return head;
    }
}
