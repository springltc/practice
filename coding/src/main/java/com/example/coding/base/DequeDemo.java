package com.example.coding.base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liutc
 * @date 2024/5/6 15:55
 */
public class DequeDemo {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(1);
        deque.offerLast(10);
        deque.offerLast(100);
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
    }
}
