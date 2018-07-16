package org.problems.graph;

import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/floyd-city-of-blinding-lights/problem
public class FloydCityofBlindingLights {

    private static int INF = 160001;

    private static void populateMinDist(int dist[][]) {
        int n = dist.length;
        for (int k = 1; k < n; k++) {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] roadNodesEdges = scanner.nextLine().split(" ");
        int roadNodes = Integer.parseInt(roadNodesEdges[0].trim());
        int roadEdges = Integer.parseInt(roadNodesEdges[1].trim());

        int dist[][] = new int[roadNodes + 1][roadNodes + 1];
        for (int i = 0; i <= roadNodes; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < roadEdges; i++) {
            String[] roadFromToWeight = scanner.nextLine().split(" ");
            int from = Integer.parseInt(roadFromToWeight[0].trim());
            int to = Integer.parseInt(roadFromToWeight[1].trim());
            dist[from][to] = Integer.parseInt(roadFromToWeight[2].trim());
        }

        populateMinDist(dist);

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xy = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xy[0]);

            int y = Integer.parseInt(xy[1]);

            if (x == y)
                System.out.println(0);
            else if (dist[x][y] == INF)
                System.out.println(-1);
            else
                System.out.println(dist[x][y]);
        }

        scanner.close();
    }
}
/*
4 5
1 2 5
1 4 24
2 4 6
3 4 4
3 2 7
3
3 1
1 2
1 4
*/
