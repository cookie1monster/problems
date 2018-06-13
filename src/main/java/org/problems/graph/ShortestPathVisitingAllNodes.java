package org.problems.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-visiting-all-nodes/description/
public class ShortestPathVisitingAllNodes {

    static class State {
        int cover, head;

        State(int c, int h) {
            cover = c;
            head = h;
        }
    }

    public static int shortestPathLength(int[][] graph) {
        int N = graph.length;
        Queue<State> queue = new LinkedList<>();
        int[][] dist = new int[1 << N][N];
        for (int[] row : dist)
            Arrays.fill(row, 1 << N);

        for (int i = 0; i < N; ++i) {
            queue.offer(new State(1 << i, i));
            dist[1 << i][i] = 0;
        }

        while (!queue.isEmpty()) {
            State state = queue.poll();
            int d = dist[state.cover][state.head];
            // All 1
            if (state.cover == (1 << N) - 1)
                return d;

            for (int child : graph[state.head]) {
                int cover = state.cover | (1 << child);
                if (d + 1 < dist[cover][child]) {
                    dist[cover][child] = d + 1;
                    queue.offer(new State(cover, child));
                }
            }
        }
        return N * N;
    }

    public static void main(String[] args) {
        System.out.println(shortestPathLength(new int[][]{{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}}));
    }
}
