package org.problems.union;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/journey-to-the-moon/problem
public class JourneytotheMoon {

    static int find(int[] astr, int x) {
        if (x != astr[x])
            astr[x] = find(astr, astr[x]);
        return astr[x];
    }

    static void union(int[] astr, int x, int y) {
        int ix = find(astr, x);
        int iy = find(astr, y);
        astr[iy] = ix;
    }

    static long journeyToMoon(int n, int[][] astronaut) {
        int[] astr = new int[n];
        for (int i = 0; i < n; ++i)
            astr[i] = i;

        for (int[] pair : astronaut)
            union(astr, pair[0], pair[1]);

        int[] freq = new int[n];
        for (int i = 0; i < n; ++i)
            ++freq[find(astr, i)];

        long result = 0;
        int left = n;
        for (int i = 0; i < n; ++i) {
            left -= freq[i];
            result += freq[i] * left;
        }
        return result;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);
        int p = Integer.parseInt(np[1]);
        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeyToMoon(n, astronaut);

        System.out.println(result);

        scanner.close();
    }
}

/*
100000 2
1 2
3 4*/
