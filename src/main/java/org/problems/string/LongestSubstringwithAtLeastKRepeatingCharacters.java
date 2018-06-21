package org.problems.string;

import java.util.Arrays;

//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
public class LongestSubstringwithAtLeastKRepeatingCharacters {

    private static boolean isValid(int[] freq, int k) {
        for (int i = 0; i < freq.length; ++i)
            if (freq[i] != 0 && freq[i] < k)
                return false;
        return true;
    }

    public static int longestSubstring(String s, int k) {
        int maxLength = 0;

        int[] freqInitial = new int[26];
        for (int i = 0; i < s.length(); ++i)
            ++freqInitial[s.charAt(i) - 'a'];

        for (int i = 0; i < s.length() - maxLength; ++i) {
            while (i < s.length() - maxLength && freqInitial[s.charAt(i) - 'a'] < k) {
                --freqInitial[s.charAt(i) - 'a'];
                ++i;
            }
            int[] freq = Arrays.copyOf(freqInitial, freqInitial.length);
            int lastIndex = i;
            for (int j = s.length() - 1; j >= i + maxLength; --j) {
                if (freq[s.charAt(j) - 'a'] >= k && isValid(freq, k)) {
                    lastIndex = j + 1;
                    break;
                }
                --freq[s.charAt(j) - 'a'];
            }
            maxLength = Math.max(maxLength, lastIndex - i);
            if (i < s.length() - maxLength)
                --freqInitial[s.charAt(i) - 'a'];
        }
        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(longestSubstring("aacbbbdc", 2) == 3);
        System.out.println(longestSubstring("weitong", 2) == 0);
        System.out.println(longestSubstring("aaabb", 3) == 3);
        System.out.println(longestSubstring("ababbc", 2) == 5);
    }
}
