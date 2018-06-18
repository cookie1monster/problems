package org.problems.string;

//https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int res = 0;
        int[] freq = new int[26];
        int start = 0;
        int maxFreq = 0;
        for (int end = 0; end < s.length(); ++end) {
            maxFreq = Math.max(maxFreq, ++freq[s.charAt(end) - 'A']);
            while (end - start + 1 - maxFreq > k) {
                --freq[s.charAt(start++) - 'A'];
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(characterReplacement("BAAAB", 2));
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1) == 4);
    }
}
