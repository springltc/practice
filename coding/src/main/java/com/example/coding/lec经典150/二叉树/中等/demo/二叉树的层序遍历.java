package com.example.coding.lec经典150.二叉树.中等.demo;


/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */

import com.example.coding.lec经典150.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * <p>
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * <p>
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 */
//https://leetcode.cn/problems/binary-tree-level-order-traversal/description/?envType=study-plan-v2&envId=top-interview-150
public class 二叉树的层序遍历 {

    public static void main(String[] args) {
        Integer[] root = {1, 2, 3, 4, 5, 6, 7};
        TreeNode treeNode = TreeNode.getTreeNode(root);
//        System.out.println(treeNode);

        List<List<Integer>> list = levelOrder(treeNode);
        System.out.println(list);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(root.val));
        add(root,map,1);

        return new ArrayList<>(map.values());
    }

    public static void add(TreeNode root, HashMap<Integer, List<Integer>> map, int level) {
        if (root.left != null) {
            List<Integer> integers = map.getOrDefault(level + 1, new ArrayList<>());
            integers.add(root.left.val);
            map.put(level + 1, integers);

            add(root.left, map, level + 1);
        }
        if (root.right != null) {
            List<Integer> integers = map.getOrDefault(level + 1, new ArrayList<>());
            integers.add(root.right.val);
            map.put(level + 1, integers);

            add(root.right, map, level + 1);
        }
    }
}

