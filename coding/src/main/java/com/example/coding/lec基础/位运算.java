package com.example.coding.lec基础;

/**
 * @author liutc
 * @date 2024/5/31 23:08
 */
public class 位运算 {

    public static void main(String[] args) {
        //& (AND) ->任何数和0做与运算，结果是0 ->任何数和其自身做与运算，结果是自身
        System.out.println(5 & 5);//5
        //| (OR) ->任何数和0做或运算，结果是自身 ->任何数和其自身做或运算，结果是自身
        System.out.println(5 | 5);//5
        //异或运算  x ^ 0 ->任何数和0做异或运算，结果是自身 ->任何数和其自身做异或运算，结果是0
        System.out.println(5 ^ 5 ^ 3 ^ 3);

    }
}
