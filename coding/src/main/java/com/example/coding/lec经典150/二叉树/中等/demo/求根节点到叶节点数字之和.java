package com.example.coding.lec经典150.二叉树.中等.demo;

import com.example.coding.lec经典150.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutc
 * @date 2024/7/16 14:19
 */
//https://leetcode.cn/problems/sum-root-to-leaf-numbers/?envType=study-plan-v2&envId=top-interview-150
public class 求根节点到叶节点数字之和 {

    public static void main(String[] args) {
//        int anInt = Integer.parseInt("009");
//        System.out.println(anInt);

        Integer[] root = {4, 9, 0, 5, 1};
        TreeNode treeNode = TreeNode.getTreeNode(root);
        int numbers = sumNumbers(treeNode);
        System.out.println(numbers);
    }

    public static int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        f(root, root.val + "", list);
        return list.get(0);
    }

    static void f(TreeNode root, String parent, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            f(root.left, parent + root.left.val, list);
        }
        if (root.right != null) {
            f(root.right, parent + root.right.val, list);
        }

        if (root.left == null && root.right == null) {
            list.set(0, list.get(0) + Integer.parseInt(parent));
        }
    }
}
