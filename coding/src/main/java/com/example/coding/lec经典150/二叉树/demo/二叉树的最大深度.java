package com.example.coding.lec经典150.二叉树.demo;

import com.example.coding.lec经典150.二叉树.TreeNode;

/**
 * @author liutc
 * @date 2024/7/9 11:20
 */
public class 二叉树的最大深度 {

    //https://leetcode.cn/problems/maximum-depth-of-binary-tree/
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
