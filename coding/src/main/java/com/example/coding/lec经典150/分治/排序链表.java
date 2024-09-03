package com.example.coding.lec经典150.分治;

import com.example.coding.lec经典150.链表.model.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 输入：head = []
 * 输出：[]
 */
public class 排序链表 {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        Collections.sort(list);

        head = new ListNode();
        head.val = list.get(0);
        ListNode next = head;
        for (int i = 1; i < list.size(); i++) {
            next.next = new ListNode(list.get(i));
            next = next.next;
        }

        return head;
    }
}
