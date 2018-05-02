package org.problems.dp;

public class WiggleSubsequence {

    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] dp = new int[nums.length + 1];
        dp[0] = 1;
        Boolean[] inc = new Boolean[nums.length + 1];
        int result = 1;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) {
                inc[i] = inc[i - 1];
                dp[i] = dp[i - 1];
                continue;
            }
            for (int j = 0; j < i; ++j) {
                if (dp[i] < dp[j] && (nums[i] < nums[j] && (inc[j] == null || inc[j]))) {
                    inc[i] = false;
                    dp[i] = dp[j];
                } else if (dp[i] < dp[j] && (nums[i] > nums[j] && (inc[j] == null || !inc[j]))) {
                    inc[i] = true;
                    dp[i] = dp[j];
                }
            }
            ++dp[i];
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{84}));
        System.out.println(wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(wiggleMaxLength(new int[]{102, 101, 20, 91, 156, 78, 75, 142, 69, 81, 46, 142, 113, 163, 190, 178, 13, 36, 134, 54}));
        System.out.println(wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));

    }
}
