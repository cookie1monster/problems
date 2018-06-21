package org.problems.array;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
public class KthSmallestElementSortedMatrix {

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((v1, v2) -> v1[0] - v2[0]);
        for (int i = 0; i < matrix.length; ++i)
            queue.offer(new int[]{matrix[i][0], i, 0});
        while (k > 1) {
            int[] val = queue.poll();
            if (val[2] < matrix.length - 1)
                queue.offer(new int[]{matrix[val[1]][val[2] + 1], val[1], val[2] + 1});
            --k;
        }
        return queue.peek()[0];
    }

    public static void main(String[] args) {

        System.out.println(kthSmallest(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}}, 5) == 5);

        System.out.println(kthSmallest(new int[][]{
                {1, 3, 4},
                {1, 8, 8},
                {4, 12, 17}}, 5) == 4);

        System.out.println(kthSmallest(new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}}, 8) == 13);
    }
}
