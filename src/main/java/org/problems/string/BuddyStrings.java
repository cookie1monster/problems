package org.problems.string;

//https://leetcode.com/problems/buddy-strings/description/
public class BuddyStrings {

    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.equals(B)) {
            boolean[] freq = new boolean[26];
            for (char ch : A.toCharArray()) {
                if (freq[ch - 'a'])
                    return true;
                else
                    freq[ch - 'a'] = true;
            }
            return false;
        }
        int toChange = 0;
        int firstIndex = -1;
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i)) {
                if (toChange == 1) {
                    if (A.charAt(i) != B.charAt(firstIndex) || A.charAt(firstIndex) != B.charAt(i))
                        return false;
                }
                ++toChange;
                firstIndex = i;
            }

            if (toChange > 2)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("ab", "ab") == false);
        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb") == true);
        System.out.println(buddyStrings("aa", "aa") == true);
    }
}
