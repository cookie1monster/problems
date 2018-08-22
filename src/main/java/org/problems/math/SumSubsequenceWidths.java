package org.problems.math;

import java.util.Arrays;

//https://leetcode.com/problems/sum-of-subsequence-widths/description/
public class SumSubsequenceWidths {

    public static int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        long sum = 0;
        long prime = 1;
        for (int len = 2; len <= A.length; ++len) {
            for (int lo = 0, hi = len - 1; hi < A.length; ++lo, ++hi) {
                sum += (A[hi] - A[lo]) * prime;
            }
            if (sum > Integer.MAX_VALUE)
                sum %= 1_000_000_007;
            prime = (prime * 2) % 1_000_000_007;
        }
        return (int) sum;
    }

    public static void main(String[] args) {

        //136988321
        System.out.println(sumSubseqWidths(new int[]{96, 87, 191, 197, 40, 101, 108, 35, 169, 50, 168, 182, 95, 80, 144, 43, 18, 60, 174, 13, 77, 173, 38, 46, 80, 117, 13, 19, 11, 6, 13, 118, 39, 80, 171, 36, 86, 156, 165, 190, 53, 49, 160, 192, 57, 42, 97, 35, 124, 200, 84, 70, 145, 180, 54, 141, 159, 42, 66, 66, 25, 95, 24, 136, 140, 159, 71, 131, 5, 140, 115, 76, 151, 137, 63, 47, 69, 164, 60, 172, 153, 183, 6, 70, 40, 168, 133, 45, 116, 188, 20, 52, 70, 156, 44, 27, 124, 59, 42, 172}));

        int[] inp = new int[20000];
        for (int i = 0; i < 20000; ++i)
            inp[i] = i;
        //System.out.println(sumSubseqWidths(inp));

        System.out.println(sumSubseqWidths(new int[]{2, 1, 3}));
        //23
        System.out.println(sumSubseqWidths(new int[]{1, 2, 3, 4}));
        //34791
        System.out.println(sumSubseqWidths(new int[]{5, 69, 89, 92, 31, 16, 25, 45, 63}));

        //857876214
        System.out.println(sumSubseqWidths(new int[]{5, 69, 89, 92, 31, 16, 25, 45, 63, 40, 16, 56, 24, 40, 75, 82, 40, 12, 50, 62, 92, 44, 67, 38, 92, 22, 91, 24, 26, 21, 100, 42, 23, 56, 64, 43, 95, 76, 84, 79, 89, 4, 16, 94, 16, 77, 92, 9, 30, 13}));


    }
}
