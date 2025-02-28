package com.example.coding.lec经典150.链表;

import com.example.coding.lec经典150.链表.model.ListNode;

/**
 * @author liutc
 * @date 2025/1/9 15:18
 */
public class 二进制链表转整数 {
    public int getDecimalValue(ListNode head) {
        int count = 0;
        ListNode pre = head;
        while(pre!=null){
            count++;
            pre = pre.next;
        }

        int sum = 0 ;
        while(head != null){
            int val = head.val;
            if(val == 1){
                sum = sum + (1<<(count-1));
            }
            count--;
            head = head.next;
        }

        return sum;
    }
}
