package com.example.coding.lec经典150.链表.demo;


import com.example.coding.lec经典150.链表.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false
 */
public class 环形链表 {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        System.out.println(set.add("a"));
        System.out.println(set.add("a"));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.add(head)) {
                head = head.next;
            } else {
                return true;
            }
        }

        return false;
    }
}
