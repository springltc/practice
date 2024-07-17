package com.example.coding.lec经典150.前缀树;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */

/**
 * 提示：
 *
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 */
//https://leetcode.cn/problems/implement-trie-prefix-tree/?envType=study-plan-v2&envId=top-interview-150
public class 实现Trie前缀树 {

    public static void main(String[] args) {

    }

    class Trie {

        class TrieNode {
            int pass;
            int end;
            TrieNode[] next;

            TrieNode() {
                pass = 0;
                end = 0;
                next = new TrieNode[26];
            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int path = word.charAt(i) - 'a';
                if (node.next[path] == null) {
                    node.next[path] = new TrieNode();
                }
                node = node.next[path];
                node.pass++;
            }
            node.end++;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int path = word.charAt(i) - 'a';
                if (node.next[path] == null) {
                    return false;
                }
                node = node.next[path];
            }
            return node.end > 0;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                int path = prefix.charAt(i) - 'a';
                if (node.next[path] == null) {
                    return false;
                }
                node = node.next[path];
            }
            return node.pass > 0;
        }
    }
}
