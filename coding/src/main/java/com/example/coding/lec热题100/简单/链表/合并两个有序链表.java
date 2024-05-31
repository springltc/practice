package com.example.coding.lec热题100.简单.链表;

import com.example.coding.lec经典150.链表.model.ListNode;

/**
 * @author liutc
 * @date 2024/5/31 10:10
 */
public class 合并两个有序链表 {

    //递归
    //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val > list2.val) {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        } else {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
    }

}
