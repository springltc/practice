package com.example.coding.lec经典150.二叉树.简单;

import com.example.coding.lec经典150.二叉树.TreeNode;

/**
 * @author liutc
 * @date 2024/7/9 11:20
 */
public class 二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftLength = maxDepth(root.left);
            int rightLength = maxDepth(root.right);
            return Math.max(rightLength, leftLength) + 1;
        }
    }
}
