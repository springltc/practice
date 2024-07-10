package com.example.coding.lec经典150.栈;

/**
 * @author liutc
 * @date 2024/7/10 16:27
 */

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 */

//https://leetcode.cn/problems/implement-queue-using-stacks/description/
public class 用栈实现队列 {

    public class MyQueue {
        Stack<Integer> in;
        Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        //void push(int x) 将元素 x 推到队列的末尾
        public void push(int x) {
            in.push(x);
            inToOut();
        }

        //int pop() 从队列的开头移除并返回元素
        public int pop() {
            inToOut();
            return out.pop();
        }

        //int peek() 返回队列开头的元素
        public int peek() {
            inToOut();
            return out.peek();
        }

        private void inToOut() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }

        //boolean empty() 如果队列为空，返回 true ；否则，返回 false
        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

}
