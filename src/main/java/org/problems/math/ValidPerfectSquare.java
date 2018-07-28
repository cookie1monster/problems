package org.problems.math;

//https://leetcode.com/problems/valid-perfect-square/description/
public class ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        if (num < 1)
            return false;

        long lo = 1;
        long hi = num;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (mid * mid == num)
                return true;
            else if (mid * mid > num)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(1));
        System.out.println(isPerfectSquare(2));
        System.out.println(isPerfectSquare(9));
        System.out.println(isPerfectSquare(4));
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(5));
        System.out.println(isPerfectSquare(0));
        System.out.println(isPerfectSquare(11));
    }
}
