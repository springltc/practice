package com.example.coding.lec经典150.二叉树.简单;

import com.example.coding.lec经典150.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 */

/**
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 */
//https://leetcode.cn/problems/average-of-levels-in-binary-tree/description/?envType=study-plan-v2&envId=top-interview-150
public class 二叉树的层平均值 {

    public static void main(String[] args) {
        Integer[] root = {1, 2, 3, 4, 5, 6, 7};
        TreeNode treeNode = TreeNode.getTreeNode(root);
//        System.out.println(treeNode);

        List<Double> doubles = averageOfLevels(treeNode);
        System.out.println(doubles);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(root.val));
        add(root, map, 1);

        ArrayList<List<Integer>> lists = new ArrayList<>(map.values());
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> integers = lists.get(i);

            double sum = 0;
            for (int j = 0; j < integers.size(); j++) {
                sum = sum + integers.get(j);
            }
            res.add(sum / integers.size());
        }

        return res;
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
