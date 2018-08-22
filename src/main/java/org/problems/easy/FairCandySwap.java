package org.problems.easy;

import java.util.Arrays;

//https://leetcode.com/problems/fair-candy-swap/description/
public class FairCandySwap {

    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        for (int a : A)
            sumA += a;

        int sumB = 0;
        for (int b : B)
            sumB += b;

        int sum = (sumA + sumB) / 2;

        for (int a : A) {
            for (int b : B) {
                if (sumA - a + b == sum && sumB - b + a == sum)
                    return new int[]{a, b};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.print(Arrays.toString(fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
    }
}
