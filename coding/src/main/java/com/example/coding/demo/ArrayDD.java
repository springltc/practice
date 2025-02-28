package com.example.coding.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liutc
 * @date 2025/1/12 19:19
 */
public class ArrayDD {

    public static void main(String[] args) {
        int[][] arr = new int[2][3];
        int[] ints1 = arr[0];


        String s = "a"+'c';
        System.out.println("a"+'c');
        Set<Integer> result = new HashSet<Integer>();


        int[] ints = new int[0];
        System.out.println(ints);

//        String s = "0P";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^0-9a-z]", "");
        if (s.equals("")) {
            return true;
        }

        int length = s.length();
        int start = 0;
        int end = length - 1;

        while (end >= start) {
            char first = s.charAt(start);
            char last = s.charAt(end);
            if (first == last) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}
