package org.problems.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutation-sequence/description/
public class PermutationSequence {

    static public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int nf = 1;
        for(int i=1; i<=n; ++i) {
            list.add(i);
            nf *= i;
        }
        return getPermutation(n, k-1, list, nf);
    }

    static public String getPermutation(int n, int k, List<Integer> list, int nf) {
        if (n == 0) return "";
        int val = k / (nf / n);
        k = k - val * (nf / n);
        return list.remove(val) + getPermutation(n - 1, k, list, nf/n);
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3,5));
    }
}
