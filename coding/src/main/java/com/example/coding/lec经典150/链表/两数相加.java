package com.example.coding.lec经典150.链表;

/**
 * @author liutc
 * @date 2024/7/3 16:11
 */

import com.example.coding.lec经典150.链表.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class 两数相加 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

//        addTwoNumbers(l1, l2);
    }

    /**
     * 两个链表反转
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //倒序的
        List<Integer> list1 = new ArrayList<>();
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }

        //倒序的
        List<Integer> list2 = new ArrayList<>();
        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }

        List<ListNode> list = new ArrayList<>();
        int add = 0;
        if (list1.size() > list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                if (list2.size() > i) {
                    int addVal = list1.get(i) + list2.get(i) + add;
                    if (addVal >= 10) {
                        add = 1;
                        addVal = addVal - 10;
                    } else {
                        add = 0;
                    }
                    ListNode listNode = new ListNode();
                    listNode.val = addVal;
                    list.add(listNode);
                } else {
                    Integer val = list1.get(i) + add;
                    if (val >= 10) {
                        add = 1;
                        val = val - 10;
                    } else {
                        add = 0;
                    }
                    ListNode listNode = new ListNode();
                    listNode.val = val;
                    list.add(listNode);
                }
            }
        } else {
            for (int i = 0; i < list2.size(); i++) {
                if (list1.size() > i) {
                    int addVal = list1.get(i) + list2.get(i) + add;
                    if (addVal >= 10) {
                        add = 1;
                        addVal = addVal - 10;
                    } else {
                        add = 0;
                    }
                    ListNode listNode = new ListNode();
                    listNode.val = addVal;
                    list.add(listNode);
                } else {
                    Integer val = list2.get(i) + add;
                    if (val >= 10) {
                        add = 1;
                        val = val - 10;
                    } else {
                        add = 0;
                    }
                    ListNode listNode = new ListNode();
                    listNode.val = val;
                    list.add(listNode);
                }
            }
        }
        if (add > 0) {
            ListNode listNode = new ListNode();
            listNode.val = 1;
            list.add(listNode);
        }

        for (int i = 0; i < list.size(); i++) {
            if (i + 1 < list.size()) {
                list.get(i).next = list.get(i + 1);
            } else {
                list.get(i).next = null;
            }
        }

        return list.get(0);
    }

    //1->2->3->null
    //3->2->1->null
//    public ListNode revertListNode(ListNode head) {
//        ListNode pre = null;
//        ListNode next = null;
//        while (head != null) {
//            next = head.next;
//
//            head.next = pre;
//            pre = head;
//
//            head = next;
//        }
//
//        return pre;
//    }
}
