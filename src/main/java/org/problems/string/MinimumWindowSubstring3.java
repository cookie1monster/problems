package org.problems.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/description/
public class MinimumWindowSubstring3 {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int[] freqT = new int[256];
        int[] freqS = new int[256];
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            ++freqT[ch];
        }

        int lo = 0;
        int hi = 0;
        while (hi < s.length() && map.size() > 0) {
            char ch = s.charAt(hi);
            ++freqS[ch];
            Integer freq = map.get(ch);
            if (freq != null) {
                if (freq == 1)
                    map.remove(ch);
                else
                    map.put(ch, freq - 1);
            }
            ++hi;
        }

        if (map.size() > 0) return "";
        String ans = s.substring(0, hi);

        while (lo <= s.length() - ans.length()) {
            Character ch = null;
            for (; lo < hi; ++lo) {
                ch = s.charAt(lo);
                --freqS[ch];
                if (freqS[ch] < freqT[ch]) {
                    if (ans.length() > hi - lo)
                        ans = s.substring(lo, hi);
                    ++lo;
                    break;
                }
            }

            if (ch == null)
                return ans;

            while (hi < s.length() && s.charAt(hi) != ch) {
                freqS[s.charAt(hi)]++;
                ++hi;
            }

            if (hi >= s.length() || ans.length() == t.length())
                return ans;

            if (s.charAt(hi) == ch) {
                freqS[s.charAt(hi)]++;
                ++hi;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("sshcxyfgecymhhpmjrfjlmiwkaunetxwleajdfrjhrxrymdkdltoxbmjdhwhatfoafzfkqquhnlhcqrfdmwdnkmtrlaueiignjlazdwirhrtzladxygnjugcfiymqgsgpggqjcaclsxmdarcyzpjuxobimnytigkqodzsdedxbscblfclwlhuzkcmychiltyzwzscdxbhpekdlmojaxdbhhphmwpxsnwqposumwbdcognawycvcefltmxqcukrraihtdvrgztuhivggxbkdgwxvtpxozqhzzoueklklgfuocaxbehfkdehztepsxwtymocybojiveyzexbkfixkmelhjabiyuinkmloavywbyvhwysbipnwtzdebgocbwpniadjxbhyaegwdaznpokkppptwdvzckokksvkteivjqtoqubfjnqadhtzmoaoaobngwxabfxmwramlduurmxutqvfhvwhjxusttuwzrixikluqfqhtndmeaulvsugprakkuhjmriueuqubhdvwgjagfndxklmbmzlgixuzhpfbhzfqccnknnqtdvsphhqvgdboaypipvlwwsnzualipebuz", "tjiazd"));
//        System.out.println(minWindow("aaflslflsldkalskaaa", "aaa"));
//        System.out.println(minWindow("abc", "a"));
//
//        System.out.println(minWindow("abc", "b"));
//        System.out.println(minWindow("adobecodebancbbcaa", "abc"));
//        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
//
//
//        System.out.println(minWindow("abc", "ab"));
//
//
//
//
//        System.out.println(minWindow("A", "A"));
//        System.out.println(minWindow("AyuihCB", "ABC"));
//        System.out.println(minWindow("ADOBECODEBANCK", "ABC"));
    }
}
