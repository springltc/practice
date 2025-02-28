package com.example.coding.lec经典150.链表;

import com.example.coding.lec经典150.链表.model.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liutc
 * @date 2025/1/9 18:04
 */
public class 链表频率 {

    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (head != null) {
            int val = head.val;
            Integer count = map.get(val);
            if (count == null) {
                map.put(val, 1);
            } else {
                map.put(val, count + 1);
            }
            head = head.next;
        }

        ListNode result = new ListNode(-1);
        ListNode res = result;
        for (Integer count : map.values()) {
            res.next = new ListNode(count);
            res = res.next;
        }

        return result.next;
    }
}
