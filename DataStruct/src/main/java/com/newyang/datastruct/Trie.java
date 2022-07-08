package com.newyang.datastruct;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    static class TrieNode {
        char val;
        List<TrieNode> child;
        boolean wordFlag;
        public TrieNode(char val) {
            this.wordFlag = false;
            this.val = val;
            this.child = new ArrayList<>();
        }

        public boolean childContain(char val) {
            for (TrieNode n : child) {
                if (n.val == val) return true;
            }
            return false;
        }

        public TrieNode getChild(char val) {
            for (TrieNode n : child) {
                if (n.val == val) return n;
            }
            return null;
        }

        public void appendChild(char val) {
            child.add(new TrieNode(val));
        }
    }

    private TrieNode start;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        start = new TrieNode(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode dummyNode = start;
        for (char c : word.toCharArray()) {
            if (!dummyNode.childContain(c)) {
                dummyNode.appendChild(c);
            }
            dummyNode = dummyNode.getChild(c);
        }
        dummyNode.wordFlag = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode dummyNode = start;
        for (char c: word.toCharArray()) {
            if (dummyNode.childContain(c)) {
                dummyNode = dummyNode.getChild(c);
            } else {
                return false;
            }
        }
        return dummyNode.wordFlag;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode dummyNode = start;
        for (char c: prefix.toCharArray()) {
            if (dummyNode.childContain(c)) {
                dummyNode = dummyNode.getChild(c);
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 True
    }
}