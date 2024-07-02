package com.example.coding.lec热题100.简单.链表.demo;

/**
 * @author liutc
 * @date 2024/2/7 14:46
 */

import com.example.coding.lec经典150.链表.model.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 */
public class 相交链表 {
    public static void main(String[] args) {
        ListNode headA = new ListNode();
        headA.val = 1;

        ListNode a2 = new ListNode();
        a2.val = 2;
        headA.next = a2;


        ListNode headB = new ListNode();
        headB.val = 2;

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pa = headA;
        ListNode pb = headB;

        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }

        return pa;
    }

    /**
     * 若相交，链表A： a+c, 链表B : b+c. a+c+b+c = b+c+a+c 。则会在公共处c起点相遇。若不相交，a +b = b+a 。因此相遇处是NULL
     */
    public ListNode getIntersectionNodeV(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }

    /**
     * 错误:因为相交后,后面的元素应该都一样
     */
    public ListNode getIntersectionNode_Error(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        List<Integer> nodes = new ArrayList<>();
        while (headA != null) {
            nodes.add(headA.val);
            headA = headA.next;
        }

        while (headB != null) {
            if (nodes.contains(headB.val)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
