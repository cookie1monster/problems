package org.problems.math;

//https://leetcode.com/problems/prime-palindrome/description/
public class PrimePalindrome {

    private static boolean isPalindrom(long val) {
        String valStr = String.valueOf(val);
        for (int i = 0; i < (valStr.length() + 1) / 2; ++i) {
            if (valStr.charAt(i) != valStr.charAt(valStr.length() - 1 - i))
                return false;
        }
        return true;
    }

    private static int reverse(int N) {
        int res = 0;
        while (N > 0) {
            res = 10 * res + (N % 10);
            N /= 10;
        }
        return res;
    }

    private static boolean isPrime(int N) {
        if (N < 2) return false;
        int hi = (int) Math.sqrt(N);
        for (int val = 2; val <= hi; ++val)
            if (N % val == 0) return false;
        return true;
    }

    public static int primePalindrome(int N) {
        if (N < 3)
            return 2;

        int n = N;
        while (true) {
            if (isPalindrom(n) && isPrime(n))
                return n;
            n += 1;

            if (10_00 < n && n < 100_00)
                n = 100_00;

            if (10_000_0 < n && n < 100_000_0)
                n = 100_000_0;

            if (10_000_000 < n && n < 100_000_000)
                n = 100_000_000;
        }
    }

    public static void main(String[] args) {
        System.out.println(primePalindrome(10_000_1));
        System.out.println(primePalindrome(1) == 2);
        System.out.println(primePalindrome(2) == 2);
        System.out.println(primePalindrome(13));
        System.out.println(primePalindrome(10));
        System.out.println(primePalindrome(101));
        System.out.println(primePalindrome(499979));
        System.out.println(primePalindrome(9989900));
        System.out.println(primePalindrome(45887963));
    }
}
