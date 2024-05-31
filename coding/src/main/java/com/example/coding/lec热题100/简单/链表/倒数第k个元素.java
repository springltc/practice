package com.example.coding.lec热题100.简单.链表;

import com.example.coding.lec经典150.链表.model.ListNode;

/**
 * @author liutc
 * @date 2024/5/31 10:04
 */
public class 倒数第k个元素 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head, q = head; //初始化
        while (k > 0) {   //将 p指针移动 k 次
            p = p.next;
            k--;
        }
        while (p != null) {//同时移动，直到 p == nullptr
            p = p.next;
            q = q.next;
        }
        return q;
    }

    //    链接：https://leetcode.cn/problems/linked-list-cycle/solutions/175734/yi-wen-gao-ding-chang-jian-de-lian-biao-wen-ti-h-2/

}
