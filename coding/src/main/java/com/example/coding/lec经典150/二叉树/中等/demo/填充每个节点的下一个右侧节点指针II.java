package com.example.coding.lec经典150.二叉树.中等.demo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liutc
 * @date 2024/7/16 14:57
 */
//https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/?envType=study-plan-v2&envId=top-interview-150
public class 填充每个节点的下一个右侧节点指针II {

    public static void main(String[] args) {
        Integer[] root = {1, 2, 3, 4, 5, null, 7};
        Node treeNode = Node.getTreeNode(root);;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

        public static Node constructTree(Integer[] arr) {
            if (arr == null || arr.length == 0) {
                return null;
            }

            Queue<Node> queue = new LinkedList<>();
            Node root = new Node(arr[0]);
            queue.offer(root);

            int i = 1;
            while (!queue.isEmpty() && i < arr.length) {
                Node current = queue.poll();

                if (arr[i] != null) {
                    current.left = new Node(arr[i]);
                    queue.offer(current.left);
                }
                i++;

                if (i < arr.length && arr[i] != null) {
                    current.right = new Node(arr[i]);
                    queue.offer(current.right);
                }
                i++;
            }

            return root;
        }

        public static Node getTreeNode(Integer[] arr) {
            return constructTree(arr);
        }
    }

    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                Node last = null;
                for (int i = 1; i <= size; i++) {
                    Node node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (i != 1) {
                        last.next = node;
                    }
                    last = node;
                }
            }

            return root;
        }
    }

}
