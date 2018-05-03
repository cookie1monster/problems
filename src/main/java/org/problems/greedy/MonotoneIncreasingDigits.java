package org.problems.greedy;

//https://leetcode.com/problems/assign-cookies/description/
public class MonotoneIncreasingDigits {

    public static int monotoneIncreasingDigits(int N) {
        int result = 0;
        int cur = N % 10;
        N /= 10;
        int offset = 1;
        while (N > 0) {
            if (cur < 1 || N % 10 > cur) {
                result = 9;
                int tmp = offset / 10;
                while (tmp > 0) {
                    result = 10 * result + 9;
                    tmp /= 10;
                }
                cur = N % 10 - 1;
            } else {
                result += offset * cur;
                cur = N % 10;
            }
            offset *= 10;
            N /= 10;
        }
        return result + offset * cur;
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(980123));
        System.out.println(monotoneIncreasingDigits(101));
        System.out.println(monotoneIncreasingDigits(332));
        System.out.println(monotoneIncreasingDigits(100));
        System.out.println(monotoneIncreasingDigits(1234));
        System.out.println(monotoneIncreasingDigits(10));
    }
}
