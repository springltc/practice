package com.example.coding.lec经典150.链表.demo;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */

import com.example.coding.lec经典150.链表.model.ListNode;

/**
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class 删除链表的倒数第N个结点 {

    //1,2,3,4,5,6,7,8,9,10
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);


        ListNode listNode = removeNthFromEnd(l1, 2);
        System.out.println(listNode);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode(0, head);

        int length = getLength(head);
        ListNode cur = listNode;
        //1 2 3 4 5 ->2(4)
        //5-2+1=4
        //循环三次 1 2 3

        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return listNode.next;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

}
