package org.problems.array;

//https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/description/
public class MinimumSwapsToMakeSequencesIncreasing {

    public static int minSwap(int[] A, int[] B) {
        int swap = 1;
        int fix = 0;
        for (int i = 1; i < A.length; i++) {
            if (!(A[i - 1] < B[i] && B[i - 1] < A[i])) {
                ++swap;
            } else if (!(A[i - 1] < A[i] && B[i - 1] < B[i])) {
                int tmp = swap;
                swap = fix + 1;
                fix = tmp;
            } else {
                int min = Math.min(swap, fix);
                swap = min + 1;
                fix = min;
            }
        }
        return Math.min(swap, fix);
    }

    public static void main(String[] args) {
        System.out.println(minSwap(new int[]{0, 3, 4, 9, 10}, new int[]{1, 2, 7, 5, 6}) == 1);
        System.out.println(minSwap(new int[]{0, 7, 8, 10, 10, 11, 12, 13, 19, 18}, new int[]{4, 4, 5, 7, 11, 14, 15, 16, 17, 20}) == 4);
        System.out.println(minSwap(new int[]{3, 3, 8, 9, 10}, new int[]{1, 7, 4, 6, 8}) == 1);
        System.out.println(minSwap(new int[]{0, 3, 5, 8, 9}, new int[]{2, 1, 4, 6, 9}) == 1);
        System.out.println(minSwap(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7}) == 1);
        System.out.println(minSwap(new int[]{2, 1, 6, 9, 10, 13, 13, 16, 19, 26, 23, 24, 25, 27, 32, 31, 35, 36, 37, 39},
                new int[]{0, 5, 8, 8, 10, 12, 14, 15, 22, 22, 28, 29, 30, 31, 30, 33, 33, 36, 37, 38}) == 6);


    }
}
