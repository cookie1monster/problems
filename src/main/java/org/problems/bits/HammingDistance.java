package org.problems.bits;

//https://leetcode.com/problems/hamming-distance/description/
public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int result = 0;
        for (int i = 0; i < 31; ++i) {
            result += (x & 1) ^ (y & 1);
            x = x >>> 1;
            y = y >>> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
