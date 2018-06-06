package org.problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/redundant-connection-ii/description/
public class RedundantConnection2 {

    private static int[] findCycleEdge(List<Integer>[] graph, int vertex, boolean[] visited, boolean[] inProgress) {
        visited[vertex] = true;
        inProgress[vertex] = true;
        if (graph[vertex] != null) {
            for (int v : graph[vertex]) {
                if (!visited[v]) {
                    int[] cycleEdge = findCycleEdge(graph, v, visited, inProgress);
                    if (cycleEdge != null) {
                        return cycleEdge;
                    }
                } else if (inProgress[v]) {
                    return new int[]{vertex, v};
                }
            }
        }
        inProgress[vertex] = false;
        return null;
    }

    public static int[] findRedundantDirectedConnection(int[][] edges) {
        // Because just one redundant edge
        int n = edges.length;
        boolean[] toVertex = new boolean[n + 1];
        List<Integer>[] graph = new List[n + 1];
        int[] res = null;
        for (int[] edge : edges) {
            if (toVertex[edge[1]]) {
                res = edge;
            } else
                toVertex[edge[1]] = true;

            if (graph[edge[0]] == null)
                graph[edge[0]] = new ArrayList<>();
            graph[edge[0]].add(edge[1]);
        }

        if (res != null) {
            int[] cycleEdge = findCycleEdge(graph, res[1], new boolean[n + 1], new boolean[n + 1]);
            if (cycleEdge != null) {
                return cycleEdge;
            }
        } else {
            for (int i = 1; i <= n; ++i) {
                int[] cycleEdge = findCycleEdge(graph, i, new boolean[n + 1], new boolean[n + 1]);
                if (cycleEdge != null) {
                    return cycleEdge;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        //[4, 1]
        System.out.println(Arrays.toString(findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}})));
        //[7, 6]
        System.out.println(Arrays.toString(findRedundantDirectedConnection(new int[][]{{6, 3}, {8, 4}, {9, 6}, {3, 2}, {5, 10}, {10, 7}, {2, 1}, {7, 6}, {4, 5}, {1, 8}})));
        //[2, 1]
        System.out.println(Arrays.toString(findRedundantDirectedConnection(new int[][]{{2, 1}, {3, 1}, {4, 2}, {1, 4}})));
        //[2, 1]
        System.out.println(Arrays.toString(findRedundantDirectedConnection(new int[][]{{3, 1}, {2, 1}, {4, 2}, {1, 4}})));
        //[2, 3]
        System.out.println(Arrays.toString(findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
    }
}
