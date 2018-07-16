package org.problems.bits;

//https://leetcode.com/contest/weekly-contest-93/problems/binary-gap/
public class BinaryGap {
    public static int binaryGap(int N) {
        int gap = 0;
        int curGap = 0;
        int n = N;
        while (n > 0) {
            if ((n & 1) == 1) {
                gap = Math.max(gap, curGap);
                curGap = 1;
            } else if (curGap >= 1)
                ++curGap;
            n = n >> 1;
        }
        return gap;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(9));
        System.out.println(binaryGap(9) == 3);
        System.out.println(binaryGap(5) == 2);
        System.out.println(binaryGap(8) == 0);
        System.out.println(binaryGap(22) == 2);
        System.out.println(binaryGap(6) == 1);
    }
}
