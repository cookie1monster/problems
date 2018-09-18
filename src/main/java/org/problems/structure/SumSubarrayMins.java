package org.problems.structure;

import java.util.Stack;

//https://leetcode.com/problems/sum-of-subarray-minimums/description/
public class SumSubarrayMins {

    public static int sumSubarrayMins(int[] A) {
        int n = A.length - 1;
        int MOD = 1000000007;

        if (A.length == 0)
            return 0;
        if (A.length == 1)
            return A[0];

        // prev has i* - 1 in increasing order of A[i* - 1]
        // where i* is the answer to query j
        Stack<Integer> stack = new Stack<>();
        int[] prev = new int[n];
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()])
                stack.pop();
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // next has k* + 1 in increasing order of A[k* + 1]
        // where k* is the answer to query j
        stack = new Stack<>();
        int[] next = new int[n];
        for (int k = n - 1; k >= 0; --k) {
            while (!stack.isEmpty() && A[k] < A[stack.peek()])
                stack.pop();
            next[k] = stack.isEmpty() ? n : stack.peek();
            stack.push(k);
        }


        long ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += (i - prev[i]) * (next[i] - i) % MOD * A[i] % MOD;
            ans %= MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{8, 41, 33, 42, 10, 91, 48, 85, 98, 35, 48, 70, 43, 31, 74, 90, 92, 63, 38, 98}));
        System.out.println(sumSubarrayMins(new int[]{71, 55, 82, 55}));
    }
}
