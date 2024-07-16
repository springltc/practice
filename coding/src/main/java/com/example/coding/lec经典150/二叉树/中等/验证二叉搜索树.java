package com.example.coding.lec经典150.二叉树.中等;


import com.example.coding.lec经典150.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
//https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-interview-150
//题目写的不是很清楚 如何定义二叉搜索树呢
public class 验证二叉搜索树 {

    public static void main(String[] args) {
        //5,4,6，null null 3,7 的这个3不能在5的右子树里面，因为3比5小……应该在4的左子树。->咱没解决
        Integer[] root = {5, 4, 6, null, null, 3, 7};
        TreeNode treeNode = TreeNode.getTreeNode(root);
        boolean validBST = isValidBST(treeNode);
        System.out.println(validBST);
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    if (node.left.val >= node.val) {
                        return false;
                    }
                }
                if (node.right != null) {
                    queue.add(node.right);
                    if (node.right.val <= node.val) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
