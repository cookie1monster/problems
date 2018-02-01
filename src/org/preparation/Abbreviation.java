package org.preparation;

import java.util.Map;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/abbr/problem
public class Abbreviation {

    static void memorize(Map<String, Boolean> m, int a, int b, boolean isAbbr) {
        m.put(Integer.toString(a)+"|"+Integer.toString(b), isAbbr);
    }

    static Boolean isMemorized(Map<String, Boolean> m, int a, int b) {
        return m.get(Integer.toString(a)+"|"+Integer.toString(b));
    }

    static boolean isAbbreviation(String a, String b, Map<String, Boolean> m) {

        if (a.length() < b.length()) {
            return false;
        }

        if (b.length() == 0) {
            return a.toLowerCase().equals(a);
        }

        if (isMemorized(m, a.length(), b.length()) != null) {
            return isMemorized(m, a.length(), b.length());
        }

        if ( (a.charAt(a.length()-1) == b.charAt(b.length()-1)) || ((char)(a.charAt(a.length()-1) - 32) == b.charAt(b.length()-1)) ) {
            boolean isAbbr = isAbbreviation(a.substring(0,a.length()-1), b.substring(0,b.length()-1), m);
            memorize(m, a.length() - 1, b.length() - 1, isAbbr);
            if (!isAbbr) {
                isAbbr = isAbbreviation(a.substring(0,a.length()-1), b, m);
                memorize(m, a.length() - 1, b.length(), isAbbr);
            }
            return isAbbr;
        } else {
            if(a.charAt(a.length()-1) >= 97) {
                memorize(m, a.length() - 1, b.length(), isAbbreviation(a.substring(0,a.length()-1), b, m));
                return isMemorized(m, a.length() - 1, b.length());
            } else {
                return false;
            }
        }
    }

    static boolean isUpcase(char c){
        return (c >= 'A') && (c <= 'Z');
    }

    static char upcase(char c){
        if (isUpcase(c))
            return c;
        return (char)(c - 32);
    }

    static String abbreviation(String a, String b) {
        boolean dp[][] = new boolean[1011][1011];
        dp[0][0] = true;

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (dp[i][j]) {
                    if(j < b.length() && (upcase(a.charAt(i)) == b.charAt(j)))
                        dp[i + 1][j + 1] = true;
                    if(!isUpcase(a.charAt(i)))
                        dp[i + 1][j] = true;
                }
            }
        }

        return dp[a.length()][b.length()] ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String a = in.next();
            String b = in.next();
            String result = abbreviation(a, b);
            System.out.println(result);
        }
        in.close();
    }
}
