package com.example.coding.lec经典150.二叉树.demo;

import com.example.coding.lec经典150.二叉树.TreeNode;

/**
 * @author liutc
 * @date 2024/7/11 09:50
 */

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 */
//https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
public class 二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int minLeftDepth = Integer.MAX_VALUE;
        int minRightDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minLeftDepth = minDepth(root.left);
        }
        if (root.right != null) {
            minRightDepth = minDepth(root.right);
        }

        return Math.min(minLeftDepth, minRightDepth) + 1;
    }
}
