package com.example.coding.lec经典150.二叉树.简单;

/**
 * @author liutc
 * @date 2024/7/11 16:33
 */

import com.example.coding.lec经典150.二叉树.TreeNode;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 */
//https://leetcode.cn/problems/count-complete-tree-nodes/solutions/21544/chang-gui-jie-fa-he-ji-bai-100de-javajie-fa-by-xia/?envType=study-plan-v2&envId=top-interview-150
public class 完全二叉树的节点个数 {


    public static void main(String[] args) {
        Integer[] root = {1, 2,3};

        TreeNode treeNode = TreeNode.constructTree(root);
        System.out.println(countNodes(treeNode));
    }

    public static int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}
