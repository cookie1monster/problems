package org.problems.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/repeated-dna-sequences/description/
//Rabin-Karp
public class RepeatedDNASequences {

    public static List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10)
            return new ArrayList<>();

        Set<Integer> indexes = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int hash = 0;
        int prime = 5;
        int factor = 1;
        for (int i = 0; i < 10; ++i) {
            hash += factor * s.charAt(i);
            factor *= prime;
        }
        factor /= prime;
        map.put(hash, 0);
        for (int i = 10; i < s.length(); ++i) {
            hash = (hash - s.charAt(i - 10)) / prime + factor * s.charAt(i);
            Integer index = map.get(hash);
            if (index != null)
                indexes.add(index);
            else
                map.put(hash, i - 9);
        }

        List<String> ans = new ArrayList<>();
        for (int index : indexes)
            ans.add(s.substring(index, index + 10));

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

        System.out.println(Integer.bitCount(1000000));
    }

}
