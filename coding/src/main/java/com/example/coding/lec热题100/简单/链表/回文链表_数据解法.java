package com.example.coding.lec热题100.简单.链表;

/**
 * @author liutc
 * @date 2024/5/31 10:28
 */

import com.example.coding.lec经典150.链表.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为
 * 回文链表
 * 。如果是，返回 true ；否则，返回 false 。
 */
public class 回文链表_数据解法 {

    public static void main(String[] args) {
//        ListNode listNode = new ListNode();
//        listNode.val = 1 ;
//
//        ListNode listNode2 = new ListNode();
//        listNode2.val=2;
//
//
//        ListNode listNode3 = new ListNode();
//        listNode3.val=2;
//        listNode2.next=listNode3;
//
//        ListNode listNode4 = new ListNode();
//        listNode4.val=1;
//        listNode3.next=listNode4;
//
//        listNode.next=listNode2;

        ListNode listNode = new ListNode();
        listNode.val = 0;

        ListNode listNode2 = new ListNode();
        listNode2.val = 0;
        listNode.next = listNode2;

        boolean palindrome = isPalindrome(listNode);
        System.out.println(palindrome);
        System.out.println(4 / 2);
    }

    /**
     * 用数组的下标
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        //1 0 1
        //1 2 2 1
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
