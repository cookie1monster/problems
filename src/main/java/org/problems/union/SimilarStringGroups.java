package org.problems.union;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/contest/weekly-contest-85/problems/similar-string-groups/
public class SimilarStringGroups {

    static boolean isSimilar(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i))
                ++count;
            if (count > 2)
                return false;
        }
        return count == 2;
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private static void union(int[] parent, int[] rank, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);
        if (rank[yroot] < rank[xroot]) {
            parent[yroot] = xroot;
        } else if (rank[yroot] > rank[xroot]) {
            parent[xroot] = yroot;
        } else {
            parent[yroot] = xroot;
            rank[xroot]++;
        }
    }

    public static int numSimilarGroups(String[] A) {
        int[] parent = new int[A.length];
        int[] rank = new int[A.length];
        for (int i = 0; i < parent.length; ++i)
            parent[i] = i;

        for (int i = 0; i < A.length; ++i) {
            for (int j = i + 1; j < A.length; ++j) {
                if (isSimilar(A[i], A[j]))
                    union(parent, rank, i, j);
            }
        }
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < parent.length; ++i) {
            res.add(find(parent, i));
        }
        return res.size();
    }

    public static void main(String[] args) {
        System.out.println(numSimilarGroups(new String[]{"kccomwcgcs",
                "socgcmcwkc",
                "sgckwcmcoc",
                "coswcmcgkc",
                "cowkccmsgc",
                "cosgmccwkc",
                "sgmkwcccoc",
                "coswmccgkc",
                "kowcccmsgc",
                "kgcomwcccs"}) == 5);
        System.out.println(numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}) == 2);
    }

}
