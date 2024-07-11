package com.example.coding.lec经典150.二叉树.简单;

/**
 * @author liutc
 * @date 2024/7/11 11:29
 */

import com.example.coding.lec经典150.二叉树.TreeNode;
import com.example.coding.spring.event.RegisterInfo;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
//https://leetcode.cn/problems/symmetric-tree/solutions/268109/dui-cheng-er-cha-shu-by-leetcode-solution/?envType=study-plan-v2&envId=top-interview-150
public class 对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return (p.val == q.val) && check(p.right, q.left) && check(p.left, q.right);
    }

}
