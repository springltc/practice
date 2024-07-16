package com.example.coding.lec经典150.二叉树.中等;

import com.example.coding.lec经典150.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */

/**
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 */
public class 二叉树展开为链表 {

    public static void main(String[] args) {
        Integer[] root = {0};
        TreeNode treeNode = TreeNode.getTreeNode(root);
        flatten(treeNode);
        System.out.println(treeNode);
    }

    public static void flatten(TreeNode root) {
        List<Integer> integers = f(root, new ArrayList<>());
        if (!integers.isEmpty()) {
            TreeNode node = root;
            for (int i = 1; i < integers.size(); i++) {
                node.left = null;
                node.right = new TreeNode(integers.get(i));

                node = node.right;
            }
        }
    }


    public static List<Integer> f(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return nodes;
        }

        nodes.add(root.val);
        f(root.left, nodes);
        f(root.right, nodes);

        return nodes;
    }
}
