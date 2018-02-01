package org.preparation;

import java.util.Scanner;

public class Sherlock {

    public static final int CHAR_SHIFT = 97;
    public static final int MAX_AMOUNT = 100001;

    static int findMostFrequent(int[] alphabetCount) {
        int[] frequentCount = new int[MAX_AMOUNT];
        for(int i = 0; i < alphabetCount.length; ++i) {
            if (alphabetCount[i] != 0) {
                frequentCount[alphabetCount[i]]++;
            }
        }

        int mostFrequent = 0;
        for(int i = 0; i < frequentCount.length; ++i) {
            if (frequentCount[mostFrequent] < frequentCount[i]) {
                mostFrequent = i;
            }
        }
        return mostFrequent;
    }

    static String isValid(String s){
        int[] alphabetCount = new int[26];
        for(int i = 0; i < s.length(); ++i) {
            alphabetCount[s.charAt(i) - CHAR_SHIFT]++;
        }

        int mostFrequent = findMostFrequent(alphabetCount);

        int charToRemoveCount = 0;
        for(int i = 0; i < alphabetCount.length; ++i) {
            if (alphabetCount[i] != 0 && mostFrequent != alphabetCount[i]) {
                charToRemoveCount += Math.min(Math.abs(alphabetCount[i] - mostFrequent), alphabetCount[i]);
            }
            if (charToRemoveCount > 1) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
