package com.example.coding.lec经典150.二叉树.中等;

import com.example.coding.lec经典150.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
//https://leetcode.cn/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=top-interview-150
public class 二叉树的右视图 {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, null, 5, null, 4};
        TreeNode treeNode = TreeNode.getTreeNode(arr);
        List<Integer> list = rightSideView(treeNode);
        System.out.println(list);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        f(root, list);

        return list;
    }

    public static void f(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i == size) {
                    list.add(node.val);
                }
            }
        }
    }
}
