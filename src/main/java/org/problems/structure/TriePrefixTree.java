package org.problems.structure;

class TrieNode {

    public static final int ALPHABET_SIZE = 26;

    TrieNode[] children;
    boolean endOfWord;

    TrieNode() {
        this.children = new TrieNode[ALPHABET_SIZE];
        this.endOfWord = false;
    }
}

class Trie {

    public static final int ALPHABET_SHIFT = 97;

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            if (node.children[word.charAt(i) - ALPHABET_SHIFT] == null) {
                node.children[word.charAt(i) - ALPHABET_SHIFT] = new TrieNode();
            }
            node = node.children[word.charAt(i) - ALPHABET_SHIFT];
        }
        node.endOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            if (node.children[word.charAt(i) - ALPHABET_SHIFT] == null) {
                return false;
            }
            node = node.children[word.charAt(i) - ALPHABET_SHIFT];
        }
        return node.endOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); ++i) {
            if (node.children[prefix.charAt(i) - ALPHABET_SHIFT] == null) {
                return false;
            }
            node = node.children[prefix.charAt(i) - ALPHABET_SHIFT];
        }
        return true;
    }
}

//https://leetcode.com/problems/implement-trie-prefix-tree/description/
public class TriePrefixTree {

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("test");
        boolean param_2 = obj.search("tet");
        boolean param_3 = obj.startsWith("tes");
        System.out.println(param_2);
        System.out.println(param_3);
    }
}
