package org.problems.easy;

//https://leetcode.com/problems/monotonic-array/description/
public class MonotonicArray {

    public static boolean isMonotonic(int[] A) {
        if (A.length < 2)
            return true;

        int i = 1;
        while (i < A.length && A[i - 1] == A[i])
            ++i;
        if (i == A.length)
            return true;
        boolean isMonot = A[i - 1] < A[i];

        if (isMonot) {
            for (; i < A.length; ++i)
                if ((A[i - 1] > A[i]))
                    return false;
        } else {
            for (; i < A.length; ++i)
                if ((A[i - 1] < A[i]))
                    return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1, 2, 2, 3}));

        System.out.println(isMonotonic(new int[]{1, 1, 1}) == true);
        System.out.println(isMonotonic(new int[]{5, 5, 4, 4}) == true);
        System.out.println(isMonotonic(new int[]{2, 2, 3, 2}) == false);
        System.out.println(isMonotonic(new int[]{1, 3, 2}) == false);
        System.out.println(isMonotonic(new int[]{2, 2, 2, 3}) == true);
    }
}
