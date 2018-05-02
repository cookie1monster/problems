package org.problems.bits;

import java.util.Arrays;

//https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/
public class PrimeNumberSetBitsBinaryRepresentation {

    private static boolean[] primeArr(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i <= n; ++i) {
            if (primes[i]) {
                for (int j = i + i; j <= n; j = j + i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }

    private static int numberHighBit(int number) {
        int i = 0;
        while (number != 0) {
            number = number >>> 1;
            ++i;
        }
        return i;
    }

    private static int numberBits(int number) {
        int count = 0;
        while (number != 0) {
            count += number & 1;
            number = number >>> 1;
        }
        return count;
    }

    public static int countPrimeSetBits(int L, int R) {
        boolean[] primes = primeArr(numberHighBit(R));
        int result = 0;
        for (int i = L; i <= R; ++i) {
            result += primes[numberBits(i)] ? 1 : 0;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(10, 15));
        System.out.println(countPrimeSetBits(6, 10));
    }
}
