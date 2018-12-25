package org.problems.dp;

//https://leetcode.com/problems/paint-fence/
public class PaintFence {

    public static int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int same = k;
        int diff = k * (k - 1);
        for (int i = 2; i < n; ++i) {
            int tmp = diff;
            diff = (same + diff) * (k - 1);
            same = tmp;
        }
        return same + diff;
    }

    public static void main(String[] args) {
        System.out.println(numWays(8, 2));
    }
}
