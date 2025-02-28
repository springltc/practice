package com.example.coding.lec经典150;

/**
 * @author liutc
 * @date 2025/1/7 17:30
 */
public class Demo2 {

    public static void main(String[] args) {
        //["a", "good", "", "", "example"] -->分隔后
       String s =  "a good   example";
        String[] split = s.split(" ");
        System.out.println(split);
    }
}
