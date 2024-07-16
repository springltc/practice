package com.example.coding.lec经典150.二叉树.中等;

import com.example.coding.lec经典150.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liutc
 * @date 2024/7/16 16:57
 */
//https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-interview-150
public class 二叉搜索树中第K小的元素 {

    public static void main(String[] args) {
        Integer[] root = {5, 3, 6, 2, 4, null, null, 1};
        int k = 3;
        int smallest = kthSmallest(TreeNode.getTreeNode(root), k);
        System.out.println(smallest);
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        f(root, list);
        Collections.sort(list);

        return list.get(k - 1);
    }

    static void f(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        f(root.left, list);
        f(root.right, list);
    }
}
