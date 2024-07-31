package com.example.coding.lec经典150.堆;

import java.util.PriorityQueue;

/**
 * @author liutc
 * @date 2024/7/31 09:38
 */
public class 堆API {

    public static void main(String[] args) {

    }

    public static void minHeap() {
        //默认小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(5);
        queue.add(4);
        queue.add(7);
        queue.add(3);
        queue.add(9);


        System.out.println("size:" + queue.size());
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.println(poll);
        }
    }

    public static void maxHeap() {
        //大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.add(5);
        queue.add(4);
        queue.add(7);
        queue.add(3);
        queue.add(9);


        System.out.println("size:" + queue.size());
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            System.out.println(poll);
        }
    }
}
