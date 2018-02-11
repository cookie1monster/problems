package org.problems.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int i = 0;
        int j = 0;
        Set<Character> alph = new HashSet<>();
        while (i<s.length()-result && j<s.length()) {
            if (alph.contains(s.charAt(j))) {
                alph.remove(s.charAt(i));
                ++i;
            } else {
                alph.add(s.charAt(j));
                ++j;
                result = Math.max(j-i, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
