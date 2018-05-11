package org.problems.graph;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/friend-circles/description/
public class FriendCircles {

    private static int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private static void union(int[] parent, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);
        parent[yroot] = xroot;
    }

    public static int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        for (int i = 0; i < parent.length; ++i)
            parent[i] = i;

        for (int i = 0; i < M.length; ++i) {
            for (int j = i + 1; j < M[0].length; ++j) {
                if (M[i][j] == 1 && find(parent, i) != find(parent, j)) {
                    union(parent, i, j);
                }
            }
        }
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < parent.length; ++i) {
            res.add(find(parent, i));
        }
        return res.size();
    }

    public static void main(String[] args) {

        System.out.println(findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}) == 1);
        System.out.println(findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}) == 2);
        System.out.println(findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}) == 1);
    }
}
