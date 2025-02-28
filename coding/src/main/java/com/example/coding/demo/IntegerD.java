package com.example.coding.demo;

/**
 * @author liutc
 * @date 2025/2/11 09:22
 */
public class IntegerD {

    public static void main(String[] args) {
        Integer integer = Integer.valueOf(5);
        Integer integer2 = Integer.valueOf(5);

        System.out.println(integer == integer2);
        System.out.println(integer.equals(integer2));
        System.out.println();
        Integer integer3 = new Integer(5);
        System.out.println(integer == integer3);
        System.out.println(integer.equals(integer3));
    }

}
