package com.example.coding.lec经典150.二叉树.中等;

import com.example.coding.lec经典150.二叉树.TreeNode;

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
        Node treeNode = Node.getTreeNode(root);
        Node connect = connect(treeNode);
        System.out.println(connect);
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

    public static Node connect(Node root) {
        List<List<Node>> levelOrder = levelOrder(root);
        for (int i = 0; i < levelOrder.size(); i++) {
            List<Node> nodes = levelOrder.get(i);
            Node next = null;
            for (int j = nodes.size() - 1; j >= 0; j--) {
                Node node = nodes.get(j);
                node.next = next;
                next = node;
            }
        }
        return root;
    }

    public static List<List<Node>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        HashMap<Node, Integer> map = new HashMap<>();
        map.put(root, 1);

        HashMap<Integer, List<Node>> listMap = new HashMap<>();
        listMap.put(1, Arrays.asList(root));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            Integer currentLevel = map.get(node);
            if (node.left != null) {
                queue.add(node.left);
                map.put(node.left, currentLevel + 1);

                List<Node> integers = listMap.getOrDefault(currentLevel + 1, new ArrayList<>());
                integers.add(node.left);
                listMap.put(currentLevel + 1, integers);
            }
            if (node.right != null) {
                queue.add(node.right);
                map.put(node.right, currentLevel + 1);

                List<Node> integers = listMap.getOrDefault(currentLevel + 1, new ArrayList<>());
                integers.add(node.right);
                listMap.put(currentLevel + 1, integers);
            }
        }

        return new ArrayList<>(listMap.values());
    }
}
