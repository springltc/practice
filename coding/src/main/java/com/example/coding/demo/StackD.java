package com.example.coding.demo;

import java.util.Stack;

/**
 * @author liutc
 * @date 2025/1/13 18:31
 */
public class StackD {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        Integer pop = stack.pop();
        System.out.println(pop);
    }
}
