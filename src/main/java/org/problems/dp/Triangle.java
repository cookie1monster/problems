package org.problems.dp;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/triangle/description/
public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty())
            return 0;
        int[] dp = new int[triangle.get(triangle.size() - 1).size() + 1];
        for (int i = triangle.size() - 1; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(minimumTotal(Arrays.asList(
                Arrays.asList(new Integer[]{-1}),
                Arrays.asList(new Integer[]{2, 3}),
                Arrays.asList(new Integer[]{1, -1, -3}))));
        System.out.println(minimumTotal(Arrays.asList(Arrays.asList(new Integer[]{2}))));
        System.out.println(minimumTotal(Arrays.asList(
                Arrays.asList(new Integer[]{2}),
                Arrays.asList(new Integer[]{3, 4}),
                Arrays.asList(new Integer[]{6, 5, 7}),
                Arrays.asList(new Integer[]{4, 1, 8, 3}))));
    }
}
