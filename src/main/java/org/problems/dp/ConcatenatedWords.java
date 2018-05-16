package org.problems.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/concatenated-words/description/
public class ConcatenatedWords {
    static class Trie {
        Trie[] children;
        boolean endOfWord;

        Trie() {
            this.children = new Trie[26];
            this.endOfWord = false;
        }
    }

    private static Trie createTrie(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie node = root;
            for (int i = 0; i < word.length(); ++i) {
                if (node.children[word.charAt(i) - 'a'] == null)
                    node.children[word.charAt(i) - 'a'] = new Trie();
                node = node.children[word.charAt(i) - 'a'];
            }
            node.endOfWord = true;
        }
        return root;
    }

    private static String extract(Trie root, String word, int qnt, Set<String> dp) {
        if (word.length() < 1)
            return null;
        if (dp.contains(word) && qnt > 0)
            return word;
        Trie node = root;
        for (int i = 0; i < word.length(); ++i) {
            if (node.children[word.charAt(i) - 'a'] != null) {
                node = node.children[word.charAt(i) - 'a'];
                if (node.endOfWord) {
                    String suffix = word.substring(i + 1);
                    if (suffix.length() == 0 && qnt > 0 || extract(root, suffix, qnt + 1, dp) != null) {
                        dp.add(word);
                        return word;
                    }
                }
            } else
                return null;
        }
        return null;
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Trie root = createTrie(words);
        root.endOfWord = false;
        Set<String> dp = new HashSet<>();
        for (String word : words) {
            String tmp = extract(root, word, 0, dp);
            if (tmp != null)
                result.add(tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAllConcatenatedWordsInADict(new String[]{"cat", "dog", "catdog"}));
        System.out.println(findAllConcatenatedWordsInADict(new String[]{"wglucmugwqi", ""}));
        System.out.println(findAllConcatenatedWordsInADict(new String[]{"cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}));
    }
}
