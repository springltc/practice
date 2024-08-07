package com.example.coding.lec经典150.二叉树.demo;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 */

/**
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 */

import com.example.coding.lec经典150.二叉树.TreeNode;

/**
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 */
//https://leetcode.cn/problems/same-tree/description/?envType=study-plan-v2&envId=top-interview-150
public class 相同的树 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (q == null || p == null) {
            return false;
        } else if (q.val != p.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
