package org.problems.graph;

import java.util.Arrays;

//https://leetcode.com/problems/redundant-connection/description/
public class RedundantConnection {

    private static int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private static void union(int[] parent, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);
        parent[xroot] = yroot;
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[1001];
        for (int i = 1; i < parent.length; ++i)
            parent[i] = i;
        for (int[] edge : edges) {
            if (find(parent, edge[0]) != find(parent, edge[1])) {
                union(parent, edge[0], edge[1]);
            } else
                return edge;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
    }
}
