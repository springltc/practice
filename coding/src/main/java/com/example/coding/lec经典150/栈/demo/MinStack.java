package com.example.coding.lec经典150.栈.demo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liutc
 * @date 2024/7/9 10:14
 */
public class MinStack {

    Deque<Integer> data;
    Deque<Integer> min;

    public MinStack() {
        data = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.isEmpty() || min.peek() > x) {
            min.push(x);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }

}
