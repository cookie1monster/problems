package org.problems.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/possible-bipartition/
public class PossibleBipartition {

    private static List<Integer>[] buildGraph(final int N, final int[][] dislikes) {
        List<Integer>[] g = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            g[i] = new ArrayList<>(N);

        for (int[] edge : dislikes) {
            g[edge[0] - 1].add(edge[1] - 1);
            g[edge[1] - 1].add(edge[0] - 1);
        }
        return g;
    }

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes.length < 1 || N < 3)
            return true;
        List<Integer>[] g = buildGraph(N, dislikes);
        int[] group = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        group[1] = 1;

        while (!que.isEmpty()) {
            int vertex = que.poll();
            if (visited[vertex]) continue;
            visited[vertex] = true;
            for (int adj : g[vertex]) {
                if (group[adj] == group[vertex])
                    return false;
                que.offer(adj);
                group[adj] = group[vertex] == 1 ? 2 : 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(possibleBipartition(10, new int[][]{{4, 7}, {4, 8}, {5, 6}, {1, 6}, {3, 7}, {2, 5}, {5, 8}, {1, 2}, {4, 9}, {6, 10}, {8, 10}, {3, 6}, {2, 10}, {9, 10}, {3, 9}, {2, 3}, {1, 9}, {4, 6}, {5, 7}, {3, 8}, {1, 8}, {1, 7}, {2, 4}}) == true);
        System.out.println(possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}) == true);
        System.out.println(possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}) == false);
        System.out.println(possibleBipartition(5, new int[][]{{1, 2}, {2, 5}, {3, 4}, {4, 5}, {1, 5}}) == false);
        System.out.println(possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}, {1, 4}}) == false);
    }
}
