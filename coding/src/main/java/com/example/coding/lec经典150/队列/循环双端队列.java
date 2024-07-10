package com.example.coding.lec经典150.队列;

/**
 * @author liutc
 * @date 2024/7/10 17:49
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * 设计实现双端队列。
 * <p>
 * 实现 MyCircularDeque 类:
 * <p>
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 */
//https://leetcode.cn/problems/design-circular-deque/description/
public class 循环双端队列 {

    class MyCircularDeque {

        Deque<Integer> queue;
        int limit;

        public MyCircularDeque(int k) {
            this.limit = k;
            queue = new LinkedList<>();
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            queue.addFirst(value);
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            queue.addLast(value);
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            queue.pollFirst();
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            queue.pollLast();
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return queue.peekFirst();
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return queue.peekLast();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public boolean isFull() {
            return queue.size() == limit;
        }
    }
}
