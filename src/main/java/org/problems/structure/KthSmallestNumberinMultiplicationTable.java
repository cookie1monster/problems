package org.problems.structure;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/
public class KthSmallestNumberinMultiplicationTable {


    public static int findKthNumber1(int m, int n, int k) {
        if (m == 1)
            return k;
        if (k == n * m)
            return n * m;

        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> {
            if (x[0] == y[0])
                return x[1] - y[1];
            return x[0] - y[0];
        });

        int nLeft = 1;
        while (k > 1) {
            if ((queue.isEmpty() || queue.peek()[0] >= nLeft) && nLeft <= n) {
                queue.offer(new int[]{nLeft, nLeft});
                ++nLeft;
            }
            int[] top = queue.poll();
            if (m * top[1] > top[0]) {
                top[0] += top[1];
                queue.offer(top);
            }
            --k;
        }
        return queue.peek()[0];
    }

    private static boolean enough(int mid, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; ++i) {
            count += Math.min(mid / i, n);
        }
        return count >= k;
    }

    public static int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            if (!enough(mid, m, n, k))
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(findKthNumber(1, 3, 2));
        System.out.println(findKthNumber(1, 3, 3) == 3);
        System.out.println(findKthNumber(3, 3, 4) == 3);
        System.out.println(findKthNumber(3, 3, 5) == 3);
        System.out.println(findKthNumber(9895, 28405, 100787757));
    }
}
