package org.problems.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/palindrome-pairs/description/
public class PalindromePairs {

    static class Node {
        int index;
        Node[] children;
        List<Integer> palindromes;

        public Node() {
            this.children = new Node[26];
            this.palindromes = new ArrayList<>();
            this.index = -1;
        }
    }


    public static List<List<Integer>> palindromePairs(String[] words) {
        Node root = buildTrie(words);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            List<Integer> indexes = findPairs(root, words[i], i);
            for (int j : indexes)
                ans.add(Arrays.asList(i, j));
        }
        return ans;
    }

    private static List<Integer> findPairs(Node node, String word, int wordIndex) {
        List<Integer> pairs = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (node.index != -1 && node.index != wordIndex && isPalindrome(word, i, word.length() - 1)) {
                pairs.add(node.index);
            }
            if (node.children[word.charAt(i) - 'a'] == null) {
                return pairs;
            }
            node = node.children[word.charAt(i) - 'a'];
        }

        for (int index : node.palindromes)
            if (index != wordIndex)
                pairs.add(index);
        return pairs;
    }

    private static boolean isPalindrome(String word, int lo, int hi) {
        while (lo < hi)
            if (word.charAt(lo++) != word.charAt(hi--))
                return false;
        return true;
    }

    private static Node buildTrie(String[] words) {
        Node root = new Node();
        for (int i = 0; i < words.length; ++i) {
            Node node = root;
            for (int j = words[i].length() - 1; j >= 0; j--) {

                if (isPalindrome(words[i], 0, j)) {
                    node.palindromes.add(i);
                }

                int ch = words[i].charAt(j) - 'a';
                if (node.children[ch] == null)
                    node.children[ch] = new Node();
                node = node.children[ch];
            }
            node.index = i;
            node.palindromes.add(i);
        }

        return root;
    }

    public static void main(String[] args) {

        System.out.println(palindromePairs(new String[]{"ab", "abc", "cba"}));
        System.out.println(palindromePairs(new String[]{"abc", "aba"}));
        System.out.println(palindromePairs(new String[]{"a", ""}));
        System.out.println(palindromePairs(new String[]{"bat", "tab", "cat"}));
        System.out.println(palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
    }

}
