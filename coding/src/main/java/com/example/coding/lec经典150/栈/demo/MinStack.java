package com.example.coding.lec经典150.栈.demo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liutc
 * @date 2024/7/9 10:14
 */
public class MinStack {

    public static void main(String[] args) {
        Deque<Integer> xStack = new LinkedList<>();
        xStack.push(1);
        xStack.push(2);
        xStack.push(3);

        Integer pop = xStack.pop();
        System.out.println(pop);
        Integer peek = xStack.peek();
        System.out.println(peek);
    }

    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    //将元素val推入堆栈。
    public void push(int x) {
        //This method is equivalent to addFirst.
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    // 删除堆栈顶部的元素。
    public void pop() {
        //This method is equivalent to removeFirst().
        xStack.pop();
        minStack.pop();
    }

    //获取堆栈顶部的元素。
    public int top() {
        //This method is equivalent to peekFirst().
        return xStack.peek();
    }

    //获取堆栈中的最小元素。
    public int getMin() {
        return minStack.peek();
    }

}
