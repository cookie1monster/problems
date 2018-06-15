package org.problems.search;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/k-th-smallest-prime-fraction/description/
public class KthSmallestPrimeFraction {

    static class PrimeFraction implements Comparable<PrimeFraction> {
        double d;
        int[] index;

        public PrimeFraction(double d, int[] index) {
            this.d = d;
            this.index = index;
        }

        @Override
        public int compareTo(final PrimeFraction o) {
            return (d < o.d) ? -1 : 1;
        }
    }

    public static int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;
        PriorityQueue<PrimeFraction> queue = new PriorityQueue<>();

        for (int i = 0; i < n - 1; ++i) {
            queue.offer(new PrimeFraction(1. * A[i] / A[n - 1], new int[]{i, n - 1}));
        }

        PrimeFraction v = null;
        int k = K;
        while (--k >= 0) {
            v = queue.poll();
            if (v.index[1] > 1)
                queue.offer(new PrimeFraction(1. * A[v.index[0]] / A[v.index[1] - 1], new int[]{v.index[0], v.index[1] - 1}));
        }
        return new int[]{A[v.index[0]], A[v.index[1]]};
    }

    public static void main(String[] args) {
        for (int i = 1; i < 400; ++i)
            System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5, 7, 13, 17, 23, 31, 41, 47, 53, 61, 67, 73, 79, 83, 97, 103, 107, 109, 131, 149, 151, 163, 167, 173, 179, 191}, i)));
        System.out.println("----------");
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 1)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 2)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 4)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 5)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 6)));
    }
}
