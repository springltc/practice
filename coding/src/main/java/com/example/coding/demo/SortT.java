package com.example.coding.demo;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author liutc
 * @date 2024/6/21 15:09
 */
public class SortT {

    public static void main(String[] args) {
//        ArrayList<Integer> list = Lists.newArrayList(2, 1, 4, 0);
        ArrayList<Integer> list = Lists.newArrayList();

        Integer integer = list.stream().min(Comparator.comparing(x -> x)).orElse(null);
        System.out.println(integer);
    }
}
