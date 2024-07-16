package com.example.coding.lec经典150.二叉树.简单;

import com.example.coding.lec经典150.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
//https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/?envType=study-plan-v2&envId=top-interview-150
public class 二叉搜索树的最小绝对差 {

    public static void main(String[] args) {
        Integer[] root = {543, 384, 652, null, 445, null, 699};
        int minimumDifference = getMinimumDifference(TreeNode.getTreeNode(root));
        System.out.println(minimumDifference);
    }

    public static int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        f(root, list);
        Collections.sort(list);

        int min = list.get(1) - list.get(0);
        int start = 1;
        int end = 2;
        while (end < list.size()) {
            min = Math.min(min, list.get(end) - list.get(start));
            start++;
            end++;
        }
        return min;
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
