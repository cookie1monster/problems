package org.problems.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/description/
public class ReachableNodesInSubdividedGraph {

    public static int reachableNodes(int[][] edges, int M, int N) {
        int res = 0;
        boolean[] visited = new boolean[N];
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; ++i)
            Arrays.fill(graph[i], -1);
        for (int i = 0; i < edges.length; ++i) {
            graph[edges[i][0]][edges[i][1]] = edges[i][2];
            graph[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        pq.offer(new int[]{0, M});
        while (!pq.isEmpty()) {
            int[] nextMove = pq.poll();
            if (visited[nextMove[0]]) continue;
            int start = nextMove[0];
            int move = nextMove[1];
            visited[start] = true;
            ++res;
            for (int i = 0; i < N; ++i) {
                if (graph[start][i] > -1) {
                    if (move > graph[start][i] && !visited[i]) {
                        pq.offer(new int[]{i, move - graph[start][i] - 1});
                    }
                    graph[i][start] -= Math.min(move, graph[start][i]);
                    res += Math.min(move, graph[start][i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((reachableNodes(new int[][]{{1, 3, 23}, {3, 5, 19}, {3, 6, 17}, {1, 5, 14}, {6, 7, 20}, {1, 4, 10}, {1, 6, 0}, {3, 4, 20}, {1, 7, 4}, {0, 4, 10}, {0, 7, 9}, {2, 3, 3}, {3, 7, 9}, {5, 7, 4}, {4, 5, 16}, {0, 1, 16}, {2, 6, 0}, {4, 7, 11}, {2, 5, 14}, {5, 6, 22}, {4, 6, 12}, {0, 6, 2}, {0, 2, 1}, {2, 4, 22}, {2, 7, 20}}
                , 19, 8)) == 301);
        System.out.println((reachableNodes(new int[][]{{3, 4, 8}, {0, 1, 3}, {1, 4, 0}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {1, 3, 3}, {2, 4, 3}, {2, 3, 3}, {0, 2, 10}}, 7, 5)) == 43);
        System.out.println((reachableNodes(new int[][]{{1, 2, 5}, {0, 3, 3}, {1, 3, 2}, {2, 3, 4}, {0, 4, 1}}, 7, 5)) == 13);
        System.out.println((reachableNodes(new int[][]{{2, 4, 2}, {3, 4, 5}, {2, 3, 1}, {0, 2, 1}, {0, 3, 5}}, 14, 5)) == 18);
        System.out.println((reachableNodes(new int[][]{{1, 2, 4}, {1, 4, 5}, {1, 3, 1}, {2, 3, 4}, {3, 4, 5}}, 17, 5)) == 1);
        System.out.println((reachableNodes(new int[][]{{0, 1, 4}, {1, 2, 6}, {0, 2, 8}, {1, 3, 1}}, 10, 4)) == 23);
        System.out.println((reachableNodes(new int[][]{{0, 1, 10}, {0, 2, 1}, {1, 2, 2}}, 6, 3)) == 13);
    }
}
