package org.problems.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/most-common-word/description/
public class MostCommonWord {

    private static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned)
            bannedSet.add(word);

        Map<String, Integer> wordFreq = new HashMap<>();
        String[] words = paragraph.toLowerCase().split("[!\\?',;\\.\\s]");
        for (String word : words) {
            if (bannedSet.contains(word) || word.isEmpty())
                continue;
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        int maxNumber = 0;
        String mostOccurredWord = "";
        for (String word : wordFreq.keySet()) {
            if (wordFreq.get(word) > maxNumber) {
                maxNumber = wordFreq.get(word);
                mostOccurredWord = word;
            }
        }

        return mostOccurredWord;
    }

    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
}
