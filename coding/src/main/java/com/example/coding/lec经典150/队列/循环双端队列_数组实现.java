package com.example.coding.lec经典150.队列;

/**
 * @author liutc
 * @date 2024/7/10 17:49
 */

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
public class 循环双端队列_数组实现 {

    class MyCircularDeque {

        int[] queue;
        int l, r, size, limit;

        public MyCircularDeque(int k) {
            queue = new int[k];
            l = 0;
            r = 0;
            size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                l = r = 0;
                queue[0] = value;
            } else {
                l = l == 0 ? (limit - 1) : l - 1;
                queue[l] = value;
            }

            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                l = r = 0;
                queue[0] = value;
            } else {
                r = r == (limit - 1) ? 0 : r + 1;
                queue[r] = value;
            }

            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            l = l == (limit - 1) ? 0 : l + 1;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }

            r = r == 0 ? (limit - 1) : r - 1;
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return queue[l];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return queue[r];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
}
