package com.example.coding.demo;

/**
 * @author liutc
 * @date 2023/12/25 11:26
 */
public class StringD {

    /**
     * 如何判断一个字符串是否是回文字符串的问题，我想你应该听过，
     * 我们今天的题目就是基于这个问题的改造版本。如果字符串是通过单链表来存储的，
     * 那该如何来判断是一个回文串呢？你有什么好的解决思路呢？相应的时间空间复杂度又是多少呢？
     */

    public static void main(String[] args) {
//        System.out.println(2%5);

//            System.out.println(12%5);


        // 在字符串常量池中创建字符串对象 ”ab“
// 将字符串对象 ”ab“ 的引用赋值给给 aa
        String aa = "ab";
//// 直接返回字符串常量池中字符串对象 ”ab“，赋值给引用 bb
        String bb = "ab";
        System.out.println(aa==bb); // true
//
        String ab = new String("ab");
        System.out.println(aa == ab);

        System.out.println(31 | 1024);
    }

}
