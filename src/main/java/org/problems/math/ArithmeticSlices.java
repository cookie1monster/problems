package org.problems.math;

//https://leetcode.com/problems/arithmetic-slices/description/
public class ArithmeticSlices {

    public static int numberOfArithmeticSlices(int[] A) {
        if (A.length < 2)
            return 0;
        int result = 0;
        int diff = A[1] - A[0];
        int count = 1;
        int i = 1;
        for (; i < A.length; ++i) {
            if (A[i] - A[i - 1] == diff) {
                ++count;
            } else {
                if (count > 2)
                    result += (count - 2) * (count - 1) / 2;
                count = 1;
                diff = A[i] - A[i - 1];
                --i;
            }
        }
        if (count > 2)
            result += (count - 2) * (count - 1) / 2;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 8, 9, 10}));
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 6, 8, 10, 12}));
    }
}
