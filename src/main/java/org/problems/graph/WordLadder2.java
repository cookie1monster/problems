package org.problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/word-ladder-ii/description/
public class WordLadder2 {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord))
            return result;

        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);
        Queue<List<String>> ladder = new LinkedList<>();
        ladder.offer(new ArrayList<>(Arrays.asList(beginWord)));

        List<String> toRemove = new ArrayList<>();
        Set<String> usedWord = new HashSet<>(Arrays.asList(beginWord));
        int level = 1;
        while (!ladder.isEmpty()) {
            List<String> wList = ladder.poll();

            if (wList.size() > level) {
                if (!result.isEmpty() && result.get(0).size() >= wList.size())
                    return result;
                usedWord.addAll(toRemove);
                toRemove.clear();
                ++level;
            }

            String word = wList.get(wList.size() - 1);
            for (int i = 0; i < word.length(); ++i) {
                char[] wordArr = word.toCharArray();
                for (char c = 'a'; c <= 'z'; ++c) {
                    wordArr[i] = c;
                    String nextWord = String.valueOf(wordArr);
                    if (!usedWord.contains(nextWord) && wordSet.contains(nextWord)) {
                        toRemove.add(nextWord);
                        List<String> newList = new ArrayList<>(wList);
                        newList.add(nextWord);
                        if (endWord.equals(nextWord)) {
                            result.add(newList);
                        } else
                            ladder.offer(newList);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLadders("red", "tax", Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee")));
        System.out.println(findLadders("hot", "dog", Arrays.asList("hot", "dog")));
        System.out.println(findLadders("hot", "dog", Arrays.asList("hot", "dog", "dot")));
        System.out.println(findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
