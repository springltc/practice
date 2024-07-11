package com.example.coding.lec经典150.二叉树.简单;

/**
 * @author liutc
 * @date 2024/7/11 15:28
 */

import com.example.coding.lec经典150.二叉树.TreeNode;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */

/**
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
//https://leetcode.cn/problems/path-sum/?envType=study-plan-v2&envId=top-interview-150
//注意提示:判空使用
public class 路径总和 {

    public static void main(String[] args) {
        Integer[] root = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        int targetSum = 22;
        TreeNode treeNode = TreeNode.constructTree(root);
        System.out.println(treeNode);
        boolean pathSum = hasPathSum(treeNode, targetSum);
        System.out.println(pathSum);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

}
