package org.problems.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/sort-characters-by-frequency/description/
public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        List<Character> sortFreq = new ArrayList<>(freq.keySet());
        sortFreq.sort((v1, v2) -> freq.get(v2) - freq.get(v1));

        int j = 0;
        for (char c : sortFreq) {
            for (int i = 0; i < freq.get(c); ++i)
                arr[j++] = c;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("r"));
    }

}
