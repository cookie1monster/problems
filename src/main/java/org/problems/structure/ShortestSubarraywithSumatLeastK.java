package org.problems.structure;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/
public class ShortestSubarraywithSumatLeastK {

    public static int shortestSubarray(int[] A, int K) {
        Deque<Integer> incIndex = new LinkedList<>();
        incIndex.addFirst(0);
        int minLength = Integer.MAX_VALUE;
        long[] prefix = new long[A.length + 1];
        for (int i = 1; i < prefix.length; ++i) {
            if (A[i - 1] >= K) return 1;
            prefix[i] = prefix[i - 1] + A[i - 1];

            while (!incIndex.isEmpty() && prefix[i] <= prefix[incIndex.peekLast()]) {
                incIndex.pollLast();
            }
            while (!incIndex.isEmpty() && prefix[i] - prefix[incIndex.peekFirst()] >= K) {
                minLength = Math.min(minLength, i - incIndex.pollFirst());
            }
            incIndex.addLast(i);
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {

        System.out.println(shortestSubarray(new int[]{-28, 81, -20, 28, -29}, 89) == 3);
        System.out.println(shortestSubarray(new int[]{17, 85, 93, -45, -21}, 150) == 2);
        System.out.println(shortestSubarray(new int[]{1, -10, 3, 4, 4, 4, 1, 3, 2, -4, 3, 4, 2}, 5) == 2);
        System.out.println(shortestSubarray(new int[]{2, -1, 2}, 3) == 3);
    }

}
