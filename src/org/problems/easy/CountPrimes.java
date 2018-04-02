package org.problems.easy;

//https://leetcode.com/problems/count-primes/description/
public class CountPrimes {

    public static int countPrimes(int n) {
        if (n < 2)
            return 0;
        int result = 0;
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; ++i) {
            if (!primes[i]) {
                ++result;
                for (int j = i; j < n; j = j + i) {
                    primes[j] = true;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(1));
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(499979));
    }
}
