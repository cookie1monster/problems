package org.problems.easy;

//https://leetcode.com/problems/powx-n/description/
public class Pow {

    private static double myPowCalculation(double x, int n) {
        if (n == 0)
            return 1.;
        return (n % 2 == 0) ? myPowCalculation(x * x, n / 2) : x * myPowCalculation(x * x, n / 2);
    }

    public static double myPow(double x, int n) {
        if (n < 0)
            x = 1 / x;
        return myPowCalculation(x, Math.abs(n));
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.00000, -3));
    }
}
