package org.problems.sort;

import java.util.Arrays;

//https://leetcode.com/problems/orderly-queue/description/
public class OrderlyQueue {

    public static String orderlyQueue(String S, int K) {
        char[] arr = S.toCharArray();
        String ans = S;
        if (K == 1) {
            for (int i = 0; i < S.length(); ++i) {
                S = S.substring(1) + S.charAt(0);
                if (ans.compareTo(S) > 0)
                    ans = S;
            }
            return ans;
        }
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(orderlyQueue("cba", 1));
        System.out.println(orderlyQueue("baaca", 3));
    }
}
