package org.problems.math;

//https://leetcode.com/contest/weekly-contest-93/problems/reordered-power-of-2/
public class ReorderedPowerof2 {

    public static boolean reorderedPowerOf2(int N) {
        int count = String.valueOf(N).length();
        long n = 1;
        while (n < Integer.MAX_VALUE && String.valueOf(n).length() != count)
            n = n << 1;

        int[] freqN = new int[10];
        for (char ch : String.valueOf(N).toCharArray())
            ++freqN[ch - '0'];

        String strN = String.valueOf(n);
        while (strN.length() == count) {
            int[] freq = new int[10];
            for (char ch : strN.toCharArray())
                ++freq[ch - '0'];
            boolean match = true;
            for (int i = 0; i < 10; ++i) {
                if (freq[i] != freqN[i]) {
                    match = false;
                    break;
                }
            }
            if (match)
                return true;

            n = n << 1;
            strN = String.valueOf(n);
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(16) == true);
        System.out.println(reorderedPowerOf2(10) == false);
        System.out.println(reorderedPowerOf2(24) == false);
        System.out.println(reorderedPowerOf2(46) == true);
    }
}
