package com.example.coding.lec经典150.链表;

import com.example.coding.lec经典150.链表.model.ListNode;

/**
 * @author liutc
 * @date 2025/1/9 17:54
 */
public class 返回倒数第k个节点 {

    public int kthToLast(ListNode head, int k) {
        ListNode pre = head;
        ListNode cur = head;

        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }

        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }

        return pre.val;
    }

}
