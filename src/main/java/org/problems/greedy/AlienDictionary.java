package org.problems.greedy;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/alien-dictionary/description/
//Topological sort
public class AlienDictionary {

    static class Node {
        char ch;
        List<Node> next;

        public Node(char ch) {
            this.ch = ch;
            next = new ArrayList<>();
        }
    }

    public static String alienOrder(String[] words) {
        if (words.length == 0) return "";
        if (words.length == 1) return words[0];
        Node[] alphabet = build(words);

        Node start = alphabet[words[0].charAt(0) - 'a'];
        boolean[] visited = new boolean[26];
        StringBuilder ans = new StringBuilder();
        if (dfs(alphabet, start, visited, new boolean[26], ans))
            return "";

        for (int i = 0; i < 26; ++i) {
            if (alphabet[i] != null && !visited[i])
                if (dfs(alphabet, alphabet[i], visited, new boolean[26], ans))
                    return "";
        }

        return ans.reverse().toString();
    }

    // return true if there is cicle
    public static boolean dfs(Node[] alphabet, Node v, boolean[] visited, boolean[] onStack, StringBuilder ans) {
        visited[v.ch - 'a'] = true;
        onStack[v.ch - 'a'] = true;
        for (Node adj : v.next) {
            if (visited[adj.ch - 'a']) {
                if (onStack[adj.ch - 'a'])
                    return true;
            } else {
                if (dfs(alphabet, adj, visited, onStack, ans))
                    return true;
            }
        }

        onStack[v.ch - 'a'] = false;
        ans.append(v.ch);
        return false;
    }

    private static Node[] build(String[] words) {
        Node[] alphabet = new Node[26];

        addChars(alphabet, words[0]);
        for (int i = 1; i < words.length; ++i) {
            addChars(alphabet, words[i]);

            int j = 0;
            for (; j < Math.min(words[i - 1].length(), words[i].length()); ++j) {
                char ch1 = words[i - 1].charAt(j);
                char ch2 = words[i].charAt(j);
                if (ch1 != ch2) {
                    alphabet[ch1 - 'a'].next.add(alphabet[ch2 - 'a']);
                    break;
                }
            }


        }
        return alphabet;
    }

    private static void addChars(Node[] alphabet, String word) {
        for (char ch : word.toCharArray()) {
            if (alphabet[ch - 'a'] == null)
                alphabet[ch - 'a'] = new Node(ch);
        }
    }

    public static void main(String[] args) {
        System.out.println(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    }
}
