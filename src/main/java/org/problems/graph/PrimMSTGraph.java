package org.problems.graph;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import org.problems.utils.FastReader;

//https://www.hackerrank.com/challenges/primsmstsub/problem
public class PrimMSTGraph {
    static class Edge implements Comparable<Edge> {
        int to;
        int dist;

        public Edge(int to, int dist) {
            this.dist = dist;
            this.to = to;
        }

        @Override
        public int compareTo(final Edge e) {
            if (dist == e.dist)
                return Integer.compare(to, e.to);
            return Integer.compare(dist, e.dist);
        }
    }

    public static int mst(Map<Integer, Set<Edge>> g, int start) {
        int mst = 0;
        Set<Integer> visited = new HashSet<>();
        NavigableSet<Edge> pq = new TreeSet<>(g.get(start));
        visited.add(start);
        while (pq.size() > 0) {
            Edge edge = pq.pollFirst();
            if (!visited.contains(edge.to)) {
                mst += edge.dist;
                visited.add(edge.to);
                pq.addAll(g.get(edge.to));
            }
        }
        return mst;
    }

    private static void addEdge(Map<Integer, Set<Edge>> g, int from, int to, int dist) {
        Set<Edge> edges = g.getOrDefault(from, new HashSet<>());
        boolean exist = false;
        for (Edge e : edges) {
            if (e.to == to) {
                exist = true;
                if (e.dist > dist)
                    e.dist = dist;
                break;
            }
        }
        if (!exist)
            edges.add(new Edge(to, dist));
        g.put(from, edges);
    }

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        int m = reader.nextInt();

        Map<Integer, Set<Edge>> g = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            int from = reader.nextInt();
            int to = reader.nextInt();
            int dist = reader.nextInt();
            addEdge(g, from, to, dist);
            addEdge(g, to, from, dist);
        }
        int result = mst(g, reader.nextInt());

        System.out.println(result);
    }
}
