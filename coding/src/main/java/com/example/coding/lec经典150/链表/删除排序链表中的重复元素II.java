package com.example.coding.lec经典150.链表;

/**
 * @author liutc
 * @date 2024/7/4 11:06
 */

import com.example.coding.lec经典150.链表.model.ListNode;

import java.lang.annotation.Target;
import java.nio.file.FileStore;
import java.util.List;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */

/**
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 */
public class 删除排序链表中的重复元素II {

    public static void main(String[] args) {
        //1,2,3,3,4,4,5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
//        l1.next.next.next = new ListNode(3);
//        l1.next.next.next.next = new ListNode(4);
//        l1.next.next.next.next.next = new ListNode(4);
//        l1.next.next.next.next.next.next = new ListNode(5);

        ListNode listNode = deleteDuplicates(l1);
        System.out.println(listNode);
    }

    //1,2,3,3,4,4,5
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = null;
        ListNode tail = null;
        int repeatCount = 0;
        while (head.next != null) {
            ListNode next = head.next;
            if (head.val == head.next.val) {
                head = head.next;
                repeatCount++;
            } else {
                if (repeatCount > 0) {
                    repeatCount = 0;
                } else {
                    if (first == null) {
                        first = tail = head;
                        head.next = null;
                    } else {
                        tail.next = head;
                        head.next = null;
                        tail = tail.next;
                    }
                }
                head = next;
            }
        }
        if (repeatCount == 0) {
            if (first == null) {
                first = tail = head;
            } else {
                tail.next = head;
            }
        }

        return first;
    }
}
