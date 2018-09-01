package org.problems.structure;

//https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
public class WordDictionaryStructure {

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("a");
        wd.addWord("ab");

        System.out.println(wd.search(".a"));
    }

}

class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean end;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.end = false;
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.end = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNode node, String word, int i) {
        if (node == null)
            return false;
        if (word.length() == i)
            return node.end;

        if (word.charAt(i) == '.') {
            for (int j = 0; j < 26; ++j)
                if (search(node.children[j], word, i + 1))
                    return true;
        } else {
            int childIndex = word.charAt(i) - 'a';
            return search(node.children[childIndex], word, i + 1);
        }
        return false;
    }
}
