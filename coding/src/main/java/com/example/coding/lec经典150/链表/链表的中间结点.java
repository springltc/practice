package com.example.coding.lec经典150.链表;

import com.example.coding.lec经典150.链表.model.ListNode;

/**
 * @author liutc
 * @date 2025/1/9 14:49
 */
public class 链表的中间结点 {

    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode pre = head;
        while (pre != null) {
            count++;
            pre = pre.next;
        }

        int m = (count / 2) + 1;

        ListNode result = null;
        int mc = 0;
        while (head != null) {
            if (++mc == m) {
                result = head;
            }
            head = head.next;
        }

        return result;
    }
}
