package com.example.coding.lec经典150.二叉树.简单;

import com.example.coding.lec经典150.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutc
 * @date 2024/7/11 14:55
 */
public class 二叉树遍历 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        /**
         *          1
         *      2       3
         *    4   5   6   7
         */

        preOrder(head);
        System.out.println();
        //头左右
        //1 2 4 5 3 6 7
        System.out.println("先序遍历递归版");

        inOrder(head);
        System.out.println();
        //左头右
        //4 2 5 1 6 3 7
        System.out.println("中序遍历递归版");

        posOrder(head);
        System.out.println();
        //左右头
        //4 5 2 6 7 3 1
        System.out.println("后序遍历递归版");
    }

    //递归序
    private static void f(TreeNode head) {
        if (head == null) {
            return;
        }
        //1
        preOrder(head.left);
        //2
        preOrder(head.right);
        //3
    }

    private static void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        preOrder(head.left);
        preOrder(head.right);
    }

    private static void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.println(head.val);
        inOrder(head.right);
    }

    private static void posOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        posOrder(head.left);
        posOrder(head.right);
        System.out.println(head.val);
    }

    //前序 -> 头左右
    //中序 -> 左头右
    //后序 -> 左右头


}
