package com.example.coding.lec经典150.二叉树.简单;

import com.example.coding.lec经典150.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutc
 * @date 2024/7/11 17:43
 */
public class 二叉树遍历_leeCode {

    //https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
    //二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public void preOrder(TreeNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        list.add(head.val);
        preOrder(head.left, list);
        preOrder(head.right, list);
    }

    //https://leetcode.cn/problems/binary-tree-inorder-traversal/
    //二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(TreeNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        inOrder(head.left, list);
        list.add(head.val);
        inOrder(head.right, list);
    }

    //https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
    //二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode head, List<Integer> list) {
        if (head == null) {
            return;
        }
        postOrder(head.left, list);
        postOrder(head.right, list);
        list.add(head.val);
    }
}
