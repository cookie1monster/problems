package org.problems.string;

//https://leetcode.com/problems/backspace-string-compare/description/
public class BackspaceStringCompare {

    public static boolean backspaceCompare(String S, String T) {
        int i1 = S.length() - 1;
        int i2 = T.length() - 1;
        int bs1 = 0;
        int bs2 = 0;

        while (i1 >= 0 || i2 >= 0) {
            while (i1 >= 0 && (S.charAt(i1) == '#' || bs1 > 0)) {
                if (S.charAt(i1) == '#') ++bs1;
                else if (bs1 > 0) --bs1;
                --i1;
                if (bs1 == 0 && i1 > 0 && S.charAt(i1) != '#') break;
            }

            while (i2 >= 0 && (T.charAt(i2) == '#' || bs2 > 0)) {
                if (T.charAt(i2) == '#') ++bs2;
                else if (bs2 > 0) --bs2;
                --i2;
                if (bs2 == 0 && i2 > 0 && T.charAt(i2) != '#') break;
            }

            if (i1 == -1 && i2 == -1)
                return true;

            if (i1 != -1 && i2 != -1 && S.charAt(i1) != T.charAt(i2))
                return false;

            --i1;
            --i2;
        }
        return i1 == -1 && i2 == -1;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("nzp#o#g", "b#nzp#o#g") == true);
        System.out.println(backspaceCompare("ab#c", "ad#c") == true);
        System.out.println(backspaceCompare("a#c", "b") == false);
        System.out.println(backspaceCompare("ab##", "c#d#") == true);


    }
}
