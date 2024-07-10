package com.example.coding.lec经典150.队列;

/**
 * @author liutc
 * @date 2024/7/10 16:43
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 */
//https://leetcode.cn/problems/implement-stack-using-queues/
public class 用队列实现栈 {

    public class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        //void push(int x) 将元素 x 压入栈顶。
        public void push(int x) {
            int size = queue.size();
            queue.offer(x);
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
        }

        //int pop() 移除并返回栈顶元素。
        public int pop() {
            return queue.poll();
        }

        //int top() 返回栈顶元素。
        public int top() {
            return queue.peek();
        }

        //boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
