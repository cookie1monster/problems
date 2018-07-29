package org.problems.dp;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/frog-jump/description/
public class FrogJump {

    private static void addK(Set<Integer>[] dp, int index, int k) {
        if (dp[index] == null)
            dp[index] = new HashSet<>();
        dp[index].add(k);
    }

    public static boolean canCross(int[] stones) {
        if (stones.length == 1)
            return true;
        if (stones.length < 1 || stones[1] != 1)
            return false;

        Set<Integer>[] dp = new Set[stones.length];
        dp[1] = new HashSet<>();
        dp[1].add(1);

        for (int i = 2; i < stones.length; ++i) {
            for (int j = i - 1; j > 0; --j) {
                if (dp[j] == null) continue;
                int maxK = 0;
                for (int k : dp[j]) {
                    if (stones[j] + k == stones[i])
                        addK(dp, i, k);
                    else if (stones[j] + k + 1 == stones[i])
                        addK(dp, i, k + 1);
                    else if (stones[j] + k - 1 == stones[i])
                        addK(dp, i, k - 1);

                    maxK = Math.max(maxK, k);
                }
                if (stones[j] + maxK + 1 <= stones[i])
                    break;
            }
        }

        return dp[stones.length - 1] != null;
    }

    public static void main(String[] args) {
        System.out.println(canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));
        System.out.println(canCross(new int[]{0, 2}));
        System.out.println(canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));
    }
}
