package com.example.coding.lec热题100.简单.链表;

import com.example.coding.lec经典150.链表.model.ListNode;

/**
 * @author liutc
 * @date 2024/5/31 09:57
 */
public class 获取中间元素 {

    public ListNode middleNode(ListNode head) {
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }
        return p;
    }

//    链接：https://leetcode.cn/problems/linked-list-cycle/solutions/175734/yi-wen-gao-ding-chang-jian-de-lian-biao-wen-ti-h-2/
}
