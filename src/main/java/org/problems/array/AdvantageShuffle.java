package org.problems.array;

import java.util.Arrays;

//https://leetcode.com/contest/weekly-contest-93/problems/advantage-shuffle/
public class AdvantageShuffle {

    public static int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int[][] indexesB = new int[B.length][2];
        for (int i = 0; i < B.length; ++i) {
            indexesB[i][0] = B[i];
            indexesB[i][1] = i;
        }
        Arrays.sort(indexesB, (x, y) -> x[0] - y[0]);

        int left = 0;
        int rigth = B.length - 1;

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; ++i) {
            if (A[i] <= indexesB[left][0]) {
                result[indexesB[rigth][1]] = A[i];
                --rigth;
            } else {
                result[indexesB[left][1]] = A[i];
                ++left;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2})));
        System.out.println(Arrays.toString(advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
        System.out.println(Arrays.toString(advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
    }
}
