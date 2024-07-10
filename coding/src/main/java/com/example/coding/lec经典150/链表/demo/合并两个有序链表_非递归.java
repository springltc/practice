package com.example.coding.lec经典150.链表.demo;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */

import com.example.coding.lec经典150.链表.model.ListNode;

/**
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class 合并两个有序链表_非递归 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = list1.val < list2.val ? list1 : list2;
        ListNode pre = head;
        ListNode c1 = head.next;
        ListNode c2 = head == list1 ? list2 : list1;
        while (c1 != null && c2 != null) {
            if (c1.val < c2.val) {
                pre.next = c1;
                c1 = c1.next;
            } else {
                pre.next = c2;
                c2 = c2.next;
            }
            pre = pre.next;
        }

        pre.next = c1 == null ? c2 : c1;
        return head;
    }
}
