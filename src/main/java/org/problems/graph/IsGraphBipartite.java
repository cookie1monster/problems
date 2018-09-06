package org.problems.graph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/is-graph-bipartite/description/
public class IsGraphBipartite {

    public static boolean isBipartite1(int[][] graph) {
        int[] color = new int[graph.length];
        int curColor = 1;
        List<Integer> level = new ArrayList<>();
        level.add(0);

        while (level.size() > 0) {
            List<Integer> nextLevel = new ArrayList<>();
            for (int node : level) {
                if (color[node] != 0) continue;
                color[node] = curColor;
                for (int i = 0; i < graph[node].length; ++i) {
                    if (color[graph[node][i]] == curColor) return false;
                    nextLevel.add(graph[node][i]);
                }
            }

            curColor = curColor == 1 ? 2 : 1;
            level = nextLevel;

            if (level.isEmpty()) {
                for (int node = 0; node < graph.length; ++node)
                    if (color[node] == 0) {
                        level.add(node);
                        break;
                    }
            }
        }
        return true;
    }


    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int node = 0; node < graph.length; ++node) {
            if (color[node] == 0 && !isBipartite(graph, node, color, 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBipartite(int[][] graph, int node, int[] color, int colorVal) {
        if (color[node] != 0) return color[node] == colorVal;
        color[node] = colorVal;
        for (int i = 0; i < graph[node].length; ++i) {
            if (!isBipartite(graph, graph[node][i], color, colorVal == 1 ? 2 : 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
        System.out.println(isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
    }
}
