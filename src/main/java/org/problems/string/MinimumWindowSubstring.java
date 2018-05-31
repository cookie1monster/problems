package org.problems.string;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-window-substring/description/
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        int lo = 0;
        int hi = 0;
        char[] arr = s.toCharArray();
        char[] freq = new char[256];
        for (char ch : t.toCharArray())
            ++freq[ch];

        char[] freqT = Arrays.copyOf(freq, freq.length);
        char[] freqS = new char[256];


        String res = s + "Q";
        int count = t.length();
        while (lo <= s.length() - t.length()) {
            while (hi < s.length() && count != 0) {
                ++freqS[arr[hi]];

                if (freq[arr[hi]] > 0) {
                    --count;
                    --freq[arr[hi]];
                }
                if (count == 0) {
                    if (hi - lo < res.length()) {
                        res = s.substring(lo, hi + 1);
                    }
                    ++hi;
                    break;
                }
                ++hi;
            }

            while (lo <= s.length() - t.length()) {
                --freqS[arr[lo]];
                if (freqS[arr[lo]] < freqT[arr[lo]]) {
                    if (count == 0 && hi - lo < res.length()) {
                        res = s.substring(lo, hi);
                    }
                    ++count;
                    ++freq[arr[lo]];
                    ++lo;
                    break;
                }
                ++lo;
            }
        }

        return (res.equals(s + "Q")) ? "" : res;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("A", "A"));
        System.out.println(minWindow("A", "A"));
        System.out.println(minWindow("AyuihCB", "ABC"));
        System.out.println(minWindow("ADOBECODEBANCK", "ABC"));
    }
}
