package com.example.coding.lec经典150.链表.demo;


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

    /**
     * 自己实现的第一板
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partitionFirst(ListNode head, int x) {
        ListNode pre = new ListNode(0);
        ListNode last = new ListNode(0);

        ListNode preFirst = null;
        ListNode lastFirst = null;
        while (head != null) {
            ListNode next = head.next;
            if (head.val < x) {
                pre.next = head;
                head.next = null;
                if (preFirst == null) {
                    preFirst = pre.next;
                }
                pre = pre.next;
            } else {
                last.next = head;
                head.next = null;
                if (lastFirst == null) {
                    lastFirst = last.next;
                }
                last = last.next;
            }
            head = next;
        }

        if (preFirst == null) {
            return lastFirst;
        } else {
            pre.next = lastFirst;
            return preFirst;
        }
    }

    /**
     * 第二版优化
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode pre = new ListNode(0);
        ListNode last = new ListNode(0);

        ListNode preFirst = pre;
        ListNode lastFirst = last;
        while (head != null) {
            ListNode next = head.next;
            if (head.val < x) {
                pre.next = head;
                pre = pre.next;
            } else {
                last.next = head;
                last = last.next;
            }
            head = next;
        }

        last.next = null;
        if (preFirst.next == null) {
            return lastFirst.next;
        } else {
            pre.next = lastFirst.next;
            return preFirst.next;
        }
    }
}
