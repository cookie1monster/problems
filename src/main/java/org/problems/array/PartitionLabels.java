package org.problems.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/partition-labels/description/
public class PartitionLabels {

    public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        Set<Character> charSet = new HashSet<>();
        int[] freq = new int[26];
        for (char ch : S.toCharArray())
            ++freq[ch - 'a'];

        int start = 0;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            --freq[ch - 'a'];
            if (freq[ch - 'a'] == 0) {
                charSet.remove(ch);
                if (charSet.isEmpty()) {
                    res.add(i - start + 1);
                    start = i + 1;
                }
            } else
                charSet.add(ch);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels(""));
        System.out.println(partitionLabels("a"));
        System.out.println(partitionLabels("abc"));
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
