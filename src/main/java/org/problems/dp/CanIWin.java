package org.problems.dp;

//https://leetcode.com/problems/predict-the-winner/description/
public class CanIWin {

    private static boolean canIWin(int n, int used, boolean turn, int desiredTotal, Boolean[] dp) {
        if (desiredTotal <= 0)
            return !turn;
        if (dp[used] != null)
            return dp[used];
        boolean canWin = !turn;
        for (int i = n; i > 0; --i) {
            if ((used >> i & 1) == 1) continue;
            canWin = canIWin(n, used | 1 << i, !turn, desiredTotal - i, dp);
            if (turn == canWin) {
                break;
            }
        }
        dp[used] = canWin;
        return canWin;
    }

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal < 2 || maxChoosableInteger >= desiredTotal) {
            return true;
        }
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) {
            return false;
        }
        Boolean[] dp = new Boolean[1 << maxChoosableInteger + 1];
        return canIWin(maxChoosableInteger, 0, true, desiredTotal, dp);
    }

    public static void main(String[] args) {
        System.out.println(canIWin(10, 40) == false);
        System.out.println(canIWin(18, 0) == true);
        System.out.println(canIWin(18, 79) == true);
        System.out.println(canIWin(10, 11) == false);
        System.out.println(canIWin(4, 6) == true);
        System.out.println(canIWin(10, 22) == false);
        System.out.println(canIWin(10, 8) == true);
    }
}
