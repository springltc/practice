package com.example.coding.lec经典150.链表.demo;


import com.example.coding.lec经典150.链表.model.ListNode;

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
public class 分隔链表_实现方式2 {

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
    public static ListNode partition(ListNode head, int x) {
        ListNode minFirst = null, minLast = null;
        ListNode maxFirst = null, maxLast = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < x) {
                if (minFirst == null) {
                    minFirst = head;
                } else {
                    minLast.next = head;
                }
                minLast = head;
            } else {
                if (maxFirst == null) {
                    maxFirst = head;
                } else {
                    maxLast.next = head;
                }
                maxLast = head;
            }
            head = next;
        }

        if (minFirst == null) {
            return maxFirst;
        }

        minLast.next = maxFirst;
        return minFirst;
    }

}
