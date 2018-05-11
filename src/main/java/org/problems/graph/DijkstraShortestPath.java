package org.problems.graph;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.problems.utils.FastReader;

//https://www.hackerrank.com/challenges/dijkstrashortreach/problem
public class DijkstraShortestPath {

    public static int[] shortestReach(int n, int[][] edges, int s) {
        boolean[] settled = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        Map<Integer, Map<Integer, Integer>> g = new HashMap<>(n + 1);
        for (int i = 1; i <= n + 1; ++i)
            g.put(i, new HashMap<>(n));

        for (int i = 0; i < edges.length; ++i) {
            if (g.get(edges[i][0]) == null || g.get(edges[i][0]).get(edges[i][1]) == null
                    || g.get(edges[i][0]).get(edges[i][1]) > edges[i][2]) {
                Map<Integer, Integer> nodes = g.get(edges[i][0]);
                nodes.put(edges[i][1], edges[i][2]);

                nodes = g.get(edges[i][1]);
                nodes.put(edges[i][0], edges[i][2]);
            }
        }

        Map<Integer, Integer> pq = new HashMap<>();
        pq.put(s, 0);
        while (pq.size() > 0) {
            int u = pollMin(pq);
            settled[u] = true;
            for (int adj : g.get(u).keySet()) {
                if (!settled[adj] && dist[adj] > dist[u] + g.get(u).get(adj)) {
                    dist[adj] = dist[u] + g.get(u).get(adj);
                    pq.put(adj, dist[adj]);
                }
            }
        }

        int i = 0;
        int[] result = new int[n - 1];
        for (int j = 1; j < dist.length; ++j) {
            if (dist[j] == Integer.MAX_VALUE)
                result[i++] = -1;
            else if (j != s)
                result[i++] = dist[j];
        }
        return result;
    }

    private static int pollMin(Map<Integer, Integer> pq) {
        int vertex = 0;
        int dist = Integer.MAX_VALUE;
        for (int v : pq.keySet()) {
            if (pq.get(v) < dist) {
                dist = pq.get(v);
                vertex = v;
            }
        }
        pq.remove(vertex);
        return vertex;
    }


        /*
    1
    4 4
    1 2 24
    1 4 20
    3 1 3
    4 3 12
    1

    1
    4 5
    1 2 24
    1 4 20
    3 1 301
    4 3 12
    2 3 1
    1
        */

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        FastReader reader = new FastReader();
        int t = reader.nextInt();

        for (int tItr = 0; tItr < t; tItr++) {
            int n = reader.nextInt();
            int m = reader.nextInt();

            int[][] edges = new int[m][3];

            for (int edgesRowItr = 0; edgesRowItr < m; edgesRowItr++) {
                for (int edgesColumnItr = 0; edgesColumnItr < 3; edgesColumnItr++) {
                    edges[edgesRowItr][edgesColumnItr] = reader.nextInt();
                }
            }

            int s = reader.nextInt();

            int[] result = shortestReach(n, edges, s);

            System.out.println(Arrays.toString(result));
            /*for (int resultItr = 0; resultItr < result.length; resultItr++) {
                bufferedWriter.write(String.valueOf(result[resultItr]));

                if (resultItr != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();*/
        }

        //bufferedWriter.close();
    }
}
