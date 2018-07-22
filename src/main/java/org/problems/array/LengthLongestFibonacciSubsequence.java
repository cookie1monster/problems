package org.problems.array;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/
public class LengthLongestFibonacciSubsequence {

    public static int lenLongestFibSubseq(int[] A) {
        int res = 0;
        Set<Long> aset = new HashSet<>();

        for (int a : A)
            aset.add((long) a);

        for (int i = 0; i < A.length - 2; ++i) {
            long cur = A[i];
            for (int j = i + 1; j < A.length - 1; ++j) {
                int curRes = 0;
                long next = A[j];
                cur = A[i];
                while (aset.contains(cur + next)) {
                    long tmp = cur + next;
                    cur = next;
                    next = tmp;
                    ++curRes;
                }
                res = Math.max(res, (curRes == 0) ? 0 : curRes + 2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq(new int[]{1, 3, 5}));
        System.out.println(lenLongestFibSubseq(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50}));
        System.out.println(lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}));
    }
}
