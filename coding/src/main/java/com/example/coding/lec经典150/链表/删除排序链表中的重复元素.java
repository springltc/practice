package com.example.coding.lec经典150.链表;

/**
 * @author liutc
 * @date 2024/7/4 11:07
 */

import com.example.coding.lec经典150.链表.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */

public class 删除排序链表中的重复元素 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
//        l1.next.next = new ListNode(2);
//        l1.next.next.next = new ListNode(3);
//        l1.next.next.next.next = new ListNode(3);

        ListNode listNode = deleteDuplicates(l1);
        System.out.println(listNode);
    }

    /**
     * 2ms
     * 击败1.73%
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null;
        ListNode tail = null;
        ListNode next = null;
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            next = head.next;
            if (pre == null) {
                head.next = null;
                pre = tail = head;
            } else {
                if (!set.contains(head.val)) {
                    head.next = null;
                    tail.next = head;
                    tail = tail.next;
                }
            }

            set.add(head.val);
            head = next;
        }

        return pre;
    }

}
