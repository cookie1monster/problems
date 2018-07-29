package org.problems.string;

//https://leetcode.com/problems/isomorphic-strings/description/
public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        int[] replaceS = new int[256];
        int[] replaceT = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            int chS = replaceS[s.charAt(i)];
            int chT = replaceT[t.charAt(i)];
            if (chS != 0 && chT != 0 && (s.charAt(i) != chT || t.charAt(i) != chS))
                return false;

            if (chS == 0 && chT != 0 && s.charAt(i) != chT)
                return false;

            if (chS != 0 && chT == 0 && t.charAt(i) != chS)
                return false;

            if (chS == 0)
                replaceS[s.charAt(i)] = t.charAt(i);
            if (chT == 0)
                replaceT[t.charAt(i)] = s.charAt(i);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add") == true);
        System.out.println(isIsomorphic("ab", "aa") == false);
        System.out.println(isIsomorphic("ab", "ca") == true);
    }
}
