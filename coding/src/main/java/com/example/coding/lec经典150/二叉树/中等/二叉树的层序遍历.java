package com.example.coding.lec经典150.二叉树.中等;


/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */

import com.example.coding.lec经典150.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

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

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);

        HashMap<Integer, List<Integer>> listMap = new HashMap<>();
        listMap.put(1, Arrays.asList(root.val));
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer currentLevel = map.get(node);
            if (node.left != null) {
                queue.add(node.left);
                map.put(node.left, currentLevel + 1);

                List<Integer> integers = listMap.getOrDefault(currentLevel + 1, new ArrayList<>());
                integers.add(node.left.val);
                listMap.put(currentLevel + 1, integers);
            }
            if (node.right != null) {
                queue.add(node.right);
                map.put(node.right, currentLevel + 1);

                List<Integer> integers = listMap.getOrDefault(currentLevel + 1, new ArrayList<>());
                integers.add(node.right.val);
                listMap.put(currentLevel + 1, integers);
            }
        }

        return new ArrayList<>(listMap.values());
    }

}

