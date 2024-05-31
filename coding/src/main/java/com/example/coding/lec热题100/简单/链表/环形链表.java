package com.example.coding.lec热题100.简单.链表;

import com.example.coding.lec经典150.链表.model.ListNode;

import java.util.HashSet;
import java.util.Set;

public class 环形链表 {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */

    public static void main(String[] args) {


    }

    //快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null && fast == slow) {
                return true;
            }
            slow = slow.next;
        }

        return false;
    }

    //    链接：https://leetcode.cn/problems/linked-list-cycle/solutions/175734/yi-wen-gao-ding-chang-jian-de-lian-biao-wen-ti-h-2/


//    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) {
//            return false;
//        }
//
//        Set<ListNode> nodes = new HashSet<>();
//        while (head != null) {
//            if (!nodes.add(head)) {
//                return true;
//            }
//            head = head.next;
//        }
//
//        return false;
//    }
}
