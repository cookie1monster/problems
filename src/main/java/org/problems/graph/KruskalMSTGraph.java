package org.problems.graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.problems.utils.FastReader;

//https://www.hackerrank.com/challenges/kruskalmstrsub/problem
public class KruskalMSTGraph {
    static class Edge {
        int from;
        int to;
        int dist;

        public Edge(int from, int to, int dist) {
            this.dist = dist;
            this.to = to;
            this.from = from;
        }
    }

    static int find(int[][] parent, int i) {
        if (parent[i][0] != i)
            parent[i][0] = find(parent, parent[i][0]);

        return parent[i][0];
    }

    static void union(int[][] parent, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);
        if (parent[xroot][1] < parent[yroot][1])
            parent[xroot][0] = yroot;
        else if (parent[xroot][1] > parent[yroot][1])
            parent[yroot][0] = xroot;
        else {
            parent[yroot][0] = xroot;
            parent[xroot][1]++;
        }
    }

    public static int mst(List<Edge> edges, int n) {
        int[][] parent = new int[n + 1][2];
        for (int i = 1; i < parent.length; ++i)
            parent[i][0] = i;
        int mst = 0;
        edges.sort(Comparator.comparingInt(e -> e.dist));
        for (Edge edge : edges) {
            int x = find(parent, edge.from);
            int y = find(parent, edge.to);
            if (x != y) {
                mst += edge.dist;
                union(parent, x, y);
            }
        }
        return mst;
    }


    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        int m = reader.nextInt();

        List<Edge> g = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            int from = reader.nextInt();
            int to = reader.nextInt();
            int dist = reader.nextInt();
            g.add(new Edge(from, to, dist));
        }
        int result = mst(g, n);

        System.out.println(result);
    }
}
