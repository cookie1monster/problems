package org.problems.graph;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.problems.utils.FastReader;

//https://www.hackerrank.com/challenges/dijkstrashortreach/problem
public class DijkstraShortestPath2 {

    static class Point implements Comparable<Point> {
        int index;
        Point parent;
        int cost;

        public Point(int index, Point parent, int cost) {
            this.index = index;
            this.parent = parent;
            this.cost = cost;
        }

        @Override
        public int compareTo(final Point o) {
            return Double.compare(cost, o.cost);
        }
    }

    public static int[] shortestReach(int n, int[][] edges, int s) {
        Map<Integer, Point> points = new HashMap<>();

        Map<Integer, Map<Integer, Integer>> g = new HashMap<>(n + 1);
        for (int i = 1; i <= n; ++i) {
            g.put(i, new HashMap<>(n));
            points.put(i, new Point(i, null, Integer.MAX_VALUE));
        }

        points.put(s, new Point(s, null, 0));

        for (int i = 0; i < edges.length; ++i) {
            if (g.get(edges[i][0]) == null || g.get(edges[i][0]).get(edges[i][1]) == null
                    || g.get(edges[i][0]).get(edges[i][1]) > edges[i][2]) {
                Map<Integer, Integer> nodes = g.get(edges[i][0]);
                nodes.put(edges[i][1], edges[i][2]);

                nodes = g.get(edges[i][1]);
                nodes.put(edges[i][0], edges[i][2]);
            }
        }

        Point start = points.get(s);
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(start);

        while (pq.size() > 0) {
            Point point = pq.poll();
            for (int adj : g.get(point.index).keySet()) {
                Point adjPoint = points.get(adj);

                if (adjPoint.cost > point.cost + g.get(point.index).get(adj)) {
                    adjPoint.cost = point.cost + g.get(point.index).get(adj);
                    adjPoint.parent = point;
                    pq.offer(adjPoint);
                }

            }
        }

        int i = 0;
        int[] result = new int[n - 1];
        for (int j = 1; j <= n; ++j) {
            if (points.get(j).cost == Integer.MAX_VALUE)
                result[i++] = -1;
            else if (j != s)
                result[i++] = points.get(j).cost;
        }
        return result;
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
