package org.problems.structure;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/optimal-account-balancing
public class OptimalAccountBalancing {

    public static int minTransfers(int[][] transactions) {
        Map<Integer, Integer> balance = new HashMap<>();
        for (int[] tran : transactions) {
            balance.put(tran[0], balance.getOrDefault(tran[0], 0) - tran[2]);
            balance.put(tran[1], balance.getOrDefault(tran[1], 0) + tran[2]);
        }
        int[] bArr = new int[balance.size()];
        int n = 0;
        for (int val : balance.values())
            if (val != 0) bArr[n++] = val;

        return reBalance(bArr, 0, n, 0);
    }

    private static int reBalance(int[] balance, int start, int n, int curAns) {
        int ans = Integer.MAX_VALUE;
        while (start < n && balance[start] == 0)
            ++start;
        for (int i = start + 1; i < n; ++i) {
            if ((balance[i] > 0 && balance[start] < 0) || (balance[i] < 0 && balance[start] > 0)) {
                balance[i] += balance[start];
                ans = Math.min(ans, reBalance(balance, start + 1, n, curAns + 1));
                balance[i] -= balance[start];
            }
        }
        return ans == Integer.MAX_VALUE ? curAns : ans;
    }

    public static void main(String[] args) {
        System.out.println(minTransfers(new int[][]{{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}}) == 1);
        System.out.println(minTransfers(new int[][]{{0, 1, 10}, {2, 0, 5}}) == 2);
    }

}
