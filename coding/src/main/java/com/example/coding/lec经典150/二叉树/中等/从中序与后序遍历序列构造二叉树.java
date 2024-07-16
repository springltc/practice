package com.example.coding.lec经典150.二叉树.中等;

import com.example.coding.lec经典150.二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
//https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/?envType=study-plan-v2&envId=top-interview-150
public class 从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode f(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2, Map<Integer, Integer> map) {
        if (l1 > r1) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[l1]);
        if (l1 == r1) {
            return treeNode;
        }
        Integer k = map.get(preorder[l1]);

        treeNode.left = f(preorder, l1 + 1, l1 + k - l2, inorder, l2, k - 1, map);
        treeNode.right = f(preorder, l1 + k - l2 + 1, r1, inorder, k + 1, r2, map);
        return treeNode;
    }
}
