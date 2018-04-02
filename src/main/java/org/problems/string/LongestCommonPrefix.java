package org.problems.string;

//https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String prefix = "";
        int leng = 0;
        while (strs[0].length() > leng) {
            char ch = strs[0].charAt(leng);
            int i = 1;
            while (i < strs.length && strs[i].length() > leng && strs[i].charAt(leng) == ch) {
                ++i;
            }
            if (i >= strs.length) {
                prefix += ch;
            } else {
                break;
            }
            ++leng;
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] { "c", "c" }));
    }
}
