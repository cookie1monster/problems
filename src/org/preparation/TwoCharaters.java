package org.preparation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TwoCharaters {

    static boolean isCorrect(String s) {
        for(int i=0; i<s.length()-1;++i) {
            if (s.charAt(i) == s.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

    static String removeStrings(String s, String s1, String s2) {
        StringBuilder newString = new StringBuilder();
        for (int i=0; i<s.length(); ++i) {
            if (s.charAt(i) == s1.charAt(0) || s.charAt(i) == s2.charAt(0)) {
                newString = newString.append(s.charAt(i));
            }
        }
        return newString.toString();
    }

    static int twoCharaters(String s) {
        Set<String> alphabetSet = new HashSet<>();
        for (int i=0; i<s.length(); ++i) {
            alphabetSet.add(s.substring(i, i + 1));
        }
        List<String> alphabet = new ArrayList<>(alphabetSet);
        int result = 0;
        if (alphabet.size() < 2) {
            return 0;
        }
        if (alphabet.size() == 2) {
            if (isCorrect(s)) {
                return s.length();
            }
            return 0;
        }
        for (int i=0; i<alphabet.size();++i) {
            for (int j=i+1; j<alphabet.size();++j) {
                String newString = removeStrings(s, alphabet.get(i), alphabet.get(j));
                if (isCorrect(newString) && result < newString.length()) {
                    result = newString.length();
                    System.out.println(newString);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = twoCharaters(s);
        System.out.println(result);
        in.close();
    }
}
