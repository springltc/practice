package com.example.coding.lec经典150.栈.demo;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */

import java.util.Stack;

/**
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class 有效的括号 {

    public static void main(String[] args) {
        Integer i = 10;
        switch (i) {
            case 10:
                System.out.println("=====" + 10);
                break;
            default:
                System.out.println("=====" + 100);
                break;
        }

        // '('，')'，'{'，'}'，'['，']'
        //s = "()[]{}"
        String s = "{[]}";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            switch (charAt) {
                case '(':
                case '{':
                case '[':
                    stack.push(charAt);
                    break;
                case ')':
                    if (stack.isEmpty() || !stack.pop().equals('(')) {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || !stack.pop().equals('[')) {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || !stack.pop().equals('{')) {
                        return false;
                    }
                    break;
                default:
                    break;
            }

        }

        return stack.isEmpty();
    }
}
