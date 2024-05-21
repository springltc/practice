package com.example.coding.lec.链表.model;

import lombok.Data;

/**
 * @author liutc
 * @date 2024/5/20 17:08
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
