package org.problems.math;

//https://leetcode.com/problems/nth-magical-number/description/
public class NmagicalNumber {

    private static int gcd(int a, int b) {
        while (b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public static int nthMagicalNumber(int N, int A, int B) {
        long M = 1000000007;
        int gcd = gcd(A, B);
        long lcm = A * B / gcd;

        long lo = 0;
        long hi = M * Math.max(A, B);

        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (mid / A + mid / B - mid / lcm < N)
                lo = mid + 1;
            else
                hi = mid;
        }
        return (int) (lo % M);
    }


    public static void main(String[] args) {
        System.out.println(nthMagicalNumber(4, 2, 3));
        System.out.println(nthMagicalNumber(5, 2, 4));
        System.out.println(nthMagicalNumber(10, 2, 3));
        System.out.println(nthMagicalNumber(1000000001, 39999, 40000) == 999887506);
    }
}
