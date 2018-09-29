package org.problems.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/description/
public class MinimumWindowSubstring2 {

    public static String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        char[] arr = s.toCharArray();
        char[] freqT = new char[256];
        char[] freqS = new char[256];
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            ++freqT[ch];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int lo = 0;
        int hi = 0;

        while (hi < arr.length && map.size() > 0) {
            if (map.containsKey(arr[hi])) {
                if (map.get(arr[hi]) == 1)
                    map.remove(arr[hi]);
                else
                    map.put(arr[hi], map.getOrDefault(arr[hi], 0) - 1);
            }
            freqS[arr[hi]]++;
            ++hi;
        }
        if (map.size() > 0)
            return "";

        String res = s.substring(lo, hi);

        while (lo <= arr.length - t.length()) {
            Character ch = null;
            while (lo < hi && ch == null) {
                if (freqT[arr[lo]] >= freqS[arr[lo]]) {
                    ch = arr[lo];
                    if (res.length() > hi - lo) {
                        res = s.substring(lo, hi);
                    }
                }
                freqS[arr[lo]]--;
                ++lo;
            }

            if (ch == null)
                return res;

            while (hi < arr.length && arr[hi] != ch) {
                freqS[arr[hi]]++;
                ++hi;
            }

            if (hi >= arr.length || res.length() == t.length())
                return res;

            if (arr[hi] == ch) {
                freqS[arr[hi]]++;
                ++hi;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("aaflslflsldkalskaaa", "aaa"));
        System.out.println(minWindow("abc", "b"));
        System.out.println(minWindow("adobecodebancbbcaa", "abc"));
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));


        System.out.println(minWindow("abc", "ab"));
        System.out.println(minWindow("abc", "a"));

        System.out.println(minWindow("sshcxyfgecymhhpmjrfjlmiwkaunetxwleajdfrjhrxrymdkdltoxbmjdhwhatfoafzfkqquhnlhcqrfdmwdnkmtrlaueiignjlazdwirhrtzladxygnjugcfiymqgsgpggqjcaclsxmdarcyzpjuxobimnytigkqodzsdedxbscblfclwlhuzkcmychiltyzwzscdxbhpekdlmojaxdbhhphmwpxsnwqposumwbdcognawycvcefltmxqcukrraihtdvrgztuhivggxbkdgwxvtpxozqhzzoueklklgfuocaxbehfkdehztepsxwtymocybojiveyzexbkfixkmelhjabiyuinkmloavywbyvhwysbipnwtzdebgocbwpniadjxbhyaegwdaznpokkppptwdvzckokksvkteivjqtoqubfjnqadhtzmoaoaobngwxabfxmwramlduurmxutqvfhvwhjxusttuwzrixikluqfqhtndmeaulvsugprakkuhjmriueuqubhdvwgjagfndxklmbmzlgixuzhpfbhzfqccnknnqtdvsphhqvgdboaypipvlwwsnzualipebuz", "tjiazd"));

        System.out.println(minWindow("A", "A"));
        System.out.println(minWindow("A", "A"));
        System.out.println(minWindow("AyuihCB", "ABC"));
        System.out.println(minWindow("ADOBECODEBANCK", "ABC"));
    }
}
